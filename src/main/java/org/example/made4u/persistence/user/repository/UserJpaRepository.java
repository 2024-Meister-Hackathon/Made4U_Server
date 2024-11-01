package org.example.made4u.persistence.user.repository;

import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends CrudRepository<UserJpaEntity, String> {

    Optional<UserJpaEntity> findByEmail(String email);

    Boolean existsByEmail(String email);
}
