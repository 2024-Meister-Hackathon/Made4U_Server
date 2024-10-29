package org.example.made4u.core.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.user.dto.request.CreateUserRequest;
import org.example.made4u.core.domain.user.exception.EmailAlreadyExistException;
import org.example.made4u.core.domain.user.service.CommendUserService;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommendUserServiceImpl implements CommendUserService {
    private final SecurityService securityService;
    private final UserJpaRepository userJpaRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void createUser(CreateUserRequest request) {
        if (userJpaRepository.findByEmail(request.email()).isPresent()) {
            throw EmailAlreadyExistException.EXCEPTION;
        }

        userJpaRepository.save(UserJpaEntity.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .nickname(request.nickname())
                .profile(request.profile().orElse(null))
                .email(request.email())
                .favor(String.join(",", request.favor()))
                .tend(String.join(",", request.tend()))
                .isVegetarian(request.isVegetarian())
                .build()
        );
    }

    @Override
    public void deleteUser() {
        String email = securityService.getCurrentUserEmail();

        userJpaRepository.deleteById(email);
    }
}
