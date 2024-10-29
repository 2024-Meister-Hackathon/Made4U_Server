package org.example.made4u.core.domain.post.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.post.dto.reqeust.UpdatePostRequest;
import org.example.made4u.core.domain.post.exception.DontHavePermissionPostException;
import org.example.made4u.core.domain.post.exception.PostNotExistException;
import org.example.made4u.core.domain.post.service.UpdatePostService;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.post.repository.PostJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdatePostServiceImpl implements UpdatePostService {
    private final PostJpaRepository postJpaRepository;
    private final SecurityService securityService;

    @Override
    public void updatePost(String postId, UpdatePostRequest request) {
        PostJpaEntity post = postJpaRepository.findByPostId(UUID.fromString(postId)).orElseThrow(
                () -> PostNotExistException.EXCEPTION
        );

        if (!post.getUser().getEmail().equals(securityService.getCurrentUserEmail())) {
            throw DontHavePermissionPostException.EXCEPTION;
        }

        String joinedTags = null;
        if (request.tags().isPresent()) {
            String[] tags = request.tags().orElseThrow(RuntimeException::new);
            joinedTags = String.join(",", tags);
        }

        postJpaRepository.save(PostJpaEntity.builder()
                .postId(UUID.fromString(postId))
                .title(request.title().orElse(null))
                .contents(request.contents().orElse(null))
                .tags(joinedTags)
                .build()
        );
    }
}
