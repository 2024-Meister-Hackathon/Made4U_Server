package org.example.made4u.core.domain.bookmark.service;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.persistence.post.entity.BookmarkJpaEntity;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.post.repository.BookmarkJpaRepository;
import org.example.made4u.persistence.post.repository.PostJpaRepository;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommendBookmarkService {
    private final SecurityService securityService;
    private final UserJpaRepository userRepository;
    private final PostJpaRepository postRepository;
    private final BookmarkJpaRepository bookmarkRepository;

    public final void createBookmark(String postId) {
        UserJpaEntity user = userRepository.findByEmail(securityService.getCurrentUserEmail())
                        .orElseThrow(() -> UserNotExistException.EXCEPTION);
        PostJpaEntity post = postRepository.findByPostId(UUID.fromString(postId))
                        .orElseThrow(RuntimeException::new);

        bookmarkRepository.save(BookmarkJpaEntity.builder()
                .user(user)
                .post(post)
                .build()
        );
    }

    public final void deleteBookmark(String postId) {
        UserJpaEntity user = userRepository.findByEmail(securityService.getCurrentUserEmail())
                .orElseThrow(() -> UserNotExistException.EXCEPTION);
        PostJpaEntity post = postRepository.findByPostId(UUID.fromString(postId))
                .orElseThrow(RuntimeException::new);
        BookmarkJpaEntity bookmark = bookmarkRepository.findByUserAndPost(user, post)
                .orElseThrow(RuntimeException::new);

        bookmarkRepository.delete(bookmark);
    }
}
