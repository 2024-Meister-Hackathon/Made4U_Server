package org.example.made4u.persistence.post.repository;

import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface PostJpaRepository extends CrudRepository<PostJpaEntity, UUID> {

    Optional<PostJpaEntity> findByPostId(UUID PostId);
}
