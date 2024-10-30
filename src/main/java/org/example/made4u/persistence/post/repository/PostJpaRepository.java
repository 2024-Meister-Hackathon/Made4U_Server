package org.example.made4u.persistence.post.repository;

import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostJpaRepository extends CrudRepository<PostJpaEntity, UUID> {

    Optional<PostJpaEntity> findByPostId(UUID PostId);

    List<PostJpaEntity> findAll(Sort sort);

    @Query("SELECT p FROM post p WHERE p.title LIKE %:keyword% OR p.contents LIKE %:keyword% OR p.tags LIKE %:keyword%")
    List<PostJpaEntity> searchByKeyword(@Param("keyword") String keyword);
}
