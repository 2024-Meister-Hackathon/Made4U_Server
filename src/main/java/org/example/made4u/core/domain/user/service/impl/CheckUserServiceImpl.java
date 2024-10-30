package org.example.made4u.core.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.user.service.CheckUserService;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CheckUserServiceImpl implements CheckUserService{
    private final UserJpaRepository userJpaRepository;

    @Override
    public Boolean checkUserExistsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }
}
