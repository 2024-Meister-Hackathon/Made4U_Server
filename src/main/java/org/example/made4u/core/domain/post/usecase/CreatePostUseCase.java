package org.example.made4u.core.domain.post.usecase;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.post.dto.reqeust.CreatePostRequest;
import org.example.made4u.core.domain.post.dto.reqeust.RecipeDto;
import org.example.made4u.core.domain.post.dto.response.CreatePostResponse;
import org.example.made4u.core.domain.post.service.CommandPostService;
import org.example.made4u.core.domain.post.service.CommandRecipeService;
import org.example.made4u.core.domain.post.service.CommandUseDataService;
import org.example.made4u.core.domain.user.service.FindUserService;
import org.example.made4u.infrastructure.thirdparty.s3.FileUploader;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreatePostUseCase {
    private final CommandPostService commandPostService;
    private final CommandRecipeService commandRecipeService;
    private final CommandUseDataService commandUseDataService;
    private final FindUserService findUserService;
    private final SecurityService securityService;
    private final FileUploader fileUploader;
    private final EntityManager entityManager;

    public CreatePostResponse execute(CreatePostRequest request, MultipartFile file) {
        UserJpaEntity user = findUserService.findUserByEmail(securityService.getCurrentUserEmail());

        // file이 존재한다면 업로드 하기
        String fileUrl = null;
        if (file != null) fileUrl = fileUploader.upload(file);

        UUID postId = UUID.randomUUID();
        PostJpaEntity postEntity = PostJpaEntity.builder()
                .postId(postId)
                .user(user)
                .title(request.title())
                .contents(request.contents())
                .mainImg(fileUrl)
                .tags(String.join(",", request.tags()))
                .build();

        commandPostService.createPost(postEntity);
        entityManager.flush(); // post의 저장 보장

        PostJpaEntity managedPostEntity = entityManager.merge(postEntity);

        commandUseDataService.createUseData(request.ingredients(), managedPostEntity);
        commandUseDataService.createUseData(request.sauce(), managedPostEntity);
        commandRecipeService.createRecipe(managedPostEntity, request.recipe());

        return new CreatePostResponse(postId.toString());
    }
}
