package org.example.made4u.core.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.user.dto.request.LoginRequest;
import org.example.made4u.core.domain.user.dto.response.LoginResponse;
import org.example.made4u.core.domain.user.exception.PasswordMismatchException;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.core.domain.user.service.LoginService;
import org.example.made4u.infrastructure.security.jwt.JwtService;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LogInServiceImpl implements LoginService {
    private final UserJpaRepository userJpaRepository;
    private final SecurityService securityService;
    private final JwtService jwtService;

    @Override
    public LoginResponse loginResponse(LoginRequest request) {
        UserJpaEntity user = userJpaRepository.findByEmail(request.email()).orElseThrow(
                () -> UserNotExistException.EXCEPTION
        );

        if (!securityService.passwordMatches(request.password(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        };

        return new LoginResponse(jwtService.generateAccess(request.email()));
    }
}
