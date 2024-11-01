package org.example.made4u.core.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.user.service.CommandUserService;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandUserServiceImpl implements CommandUserService {
    private final UserJpaRepository userJpaRepository;

    @Override
    public void createUser(UserJpaEntity user) {
        userJpaRepository.save(user);
    }

    @Override
    public void deleteUserByEmail(String email) {
        userJpaRepository.deleteById(email);
    }
}
