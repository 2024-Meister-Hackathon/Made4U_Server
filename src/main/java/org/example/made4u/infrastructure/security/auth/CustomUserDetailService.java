package org.example.made4u.infrastructure.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService {
    private final UserJpaRepository userRepository;

    public CustomUserDetail getCustomUserDetailByEmail(String email) {
        UserJpaEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotExistException.EXCEPTION);

        return new CustomUserDetail(user.getEmail());
    }
}
