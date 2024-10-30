package org.example.made4u.persistence.post.repository;

import org.example.made4u.persistence.post.entity.BookMarkId;
import org.example.made4u.persistence.post.entity.BookmarkJpaEntity;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookmarkJpaRepository extends CrudRepository<BookmarkJpaEntity, BookMarkId> {

    Optional<BookmarkJpaEntity> findByUserAndPost(UserJpaEntity user, PostJpaEntity post);

    List<BookmarkJpaEntity> findAllByUser(UserJpaEntity user);
}
