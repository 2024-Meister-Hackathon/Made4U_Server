package org.example.made4u.persistence.post.repository;

import org.example.made4u.persistence.post.entity.RecipeJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RecipeJpaRepository extends CrudRepository<RecipeJpaEntity, UUID> {

}
