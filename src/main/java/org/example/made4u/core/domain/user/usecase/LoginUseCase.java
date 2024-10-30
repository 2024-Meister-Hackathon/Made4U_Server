package org.example.made4u.core.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.user.dto.request.LoginRequest;
import org.example.made4u.core.domain.user.dto.response.LoginResponse;
import org.example.made4u.core.domain.user.exception.PasswordMismatchException;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.core.domain.user.service.FindUserService;
import org.example.made4u.infrastructure.security.jwt.JwtService;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginUseCase {
    private final FindUserService findUserService;
    private final SecurityService securityService;
    private final JwtService jwtService;

    public LoginResponse execute(LoginRequest request) {
        UserJpaEntity user = findUserService.findUserByEmail(request.email());

        if (!securityService.passwordMatches(request.password(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        };

        return new LoginResponse(jwtService.generateAccess(request.email()));
    }
}
