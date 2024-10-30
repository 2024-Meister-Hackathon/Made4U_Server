package org.example.made4u.core.domain.post.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.post.dto.reqeust.CreatePostRequest;
import org.example.made4u.core.domain.post.dto.reqeust.RecipeDto;
import org.example.made4u.core.domain.post.dto.response.CreatePostResponse;
import org.example.made4u.core.domain.post.exception.DontHavePermissionPostException;
import org.example.made4u.core.domain.post.exception.PostNotExistException;
import org.example.made4u.core.domain.post.service.CommandPostService;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.core.domain.user.service.FindUserService;
import org.example.made4u.infrastructure.thirdparty.s3.FileUploader;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.post.entity.RecipeJpaEntity;
import org.example.made4u.persistence.post.repository.PostJpaRepository;
import org.example.made4u.persistence.post.repository.RecipeJpaRepository;
import org.example.made4u.persistence.product.entity.UseJpaEntity;
import org.example.made4u.persistence.product.repository.ProductJpaRepository;
import org.example.made4u.persistence.product.repository.UseJpaRepository;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandPostServiceImpl implements CommandPostService {
    private final PostJpaRepository postJpaRepository;
    private final SecurityService securityService;
    private final ProductJpaRepository productJpaRepository;
    private final UseJpaRepository useJpaRepository;
    private final RecipeJpaRepository recipeJpaRepository;

    @Override
    public void createPost(PostJpaEntity post) {
        postJpaRepository.save(post);


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
