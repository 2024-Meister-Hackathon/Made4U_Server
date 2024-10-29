package org.example.made4u.infrastructure.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtProperties jwtProperties;

    public String generateAccess(String email) {
        Long now = (new Date()).getTime();
        Date expireAt = new Date(now + jwtProperties.access_expire());

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret())
                .setSubject(email)
                .setExpiration(expireAt)
                .compact();
    }
}
