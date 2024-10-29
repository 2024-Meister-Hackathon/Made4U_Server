package org.example.made4u.core.domain.post.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.post.dto.reqeust.CreatePostRequest;
import org.example.made4u.core.domain.post.dto.response.CreatePostResponse;
import org.example.made4u.core.domain.post.exception.DontHavePermissionPostException;
import org.example.made4u.core.domain.post.exception.PostNotExistException;
import org.example.made4u.core.domain.post.service.CommendPostService;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.post.repository.PostJpaRepository;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CommendPostServiceImpl implements CommendPostService {
    private final PostJpaRepository postJpaRepository;
    private final SecurityService securityService;
    private final UserJpaRepository userJpaRepository;

    @Override
    public CreatePostResponse createPost(CreatePostRequest request) {
        UserJpaEntity user = userJpaRepository.findByEmail(securityService.getCurrentUserEmail()).orElseThrow(
                () -> UserNotExistException.EXCEPTION
        );

        UUID postId = UUID.randomUUID();
        postJpaRepository.save(PostJpaEntity.builder()
                    .postId(postId)
                    .user(user)
                    .title(request.title())
                    .contents(request.contents())
                    .tags(String.join(",", request.tags()))
                    .build()
        );

        return new CreatePostResponse(postId.toString());
    }

    @Override
    public void deletePost(String postId) {
        PostJpaEntity post = postJpaRepository.findByPostId(UUID.fromString(postId)).orElseThrow(
                () -> PostNotExistException.EXCEPTION
        );

        if (!post.getUser().getEmail().equals(securityService.getCurrentUserEmail())) {
            throw DontHavePermissionPostException.EXCEPTION;
        }

        postJpaRepository.deleteById(UUID.fromString(postId));
    }
}
