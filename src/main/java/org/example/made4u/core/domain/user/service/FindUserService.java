package org.example.made4u.core.domain.user.service;

import org.example.made4u.persistence.user.entity.UserJpaEntity;

public interface FindUserService {

    UserJpaEntity findUserByEmail(String email);
}
