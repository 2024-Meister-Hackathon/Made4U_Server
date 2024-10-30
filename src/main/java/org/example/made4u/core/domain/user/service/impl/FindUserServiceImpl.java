package org.example.made4u.core.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.core.domain.user.service.FindUserService;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserServiceImpl implements FindUserService {
    private final UserJpaRepository userRepository;

    @Override
    public UserJpaEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> UserNotExistException.EXCEPTION
        );
    }
}
