package org.example.made4u.infrastructure.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.made4u.infrastructure.security.auth.CustomUserDetail;
import org.example.made4u.infrastructure.security.auth.CustomUserDetailService;
import org.example.made4u.infrastructure.security.exception.TokenParsingException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtParser {
    private final JwtProperties jwtProperties;
    private final CustomUserDetailService customUserDetailService;

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);

        CustomUserDetail detail = getDetail(claims.getSubject());

        return new UsernamePasswordAuthenticationToken(detail.email(), "", detail.getAuthorities());
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser()
                .setSigningKey(jwtProperties.secret())
                .parseClaimsJws(token)
                .getBody();
        } catch (Exception e) {
            throw TokenParsingException.EXCEPTION;
        }
    }

    private CustomUserDetail getDetail(String email) {
        return customUserDetailService.getCustomUserDetailByEmail(email);
    }

    public String getHeader(HttpServletRequest request) {
        String header = request.getHeader(jwtProperties.header());

        if (header.startsWith(jwtProperties.prefix()) && header.length() > 7) {
            return header.split(" ")[1];
        }
        return null;
    }
}
