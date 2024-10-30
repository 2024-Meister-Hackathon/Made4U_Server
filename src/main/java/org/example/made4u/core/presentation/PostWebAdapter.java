package org.example.made4u.core.presentation;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.post.dto.reqeust.CreatePostRequest;
import org.example.made4u.core.domain.post.dto.reqeust.UpdatePostRequest;
import org.example.made4u.core.domain.post.dto.response.CreatePostResponse;
import org.example.made4u.core.domain.post.dto.response.searchProduction.SearchProductionResponse;
import org.example.made4u.core.domain.post.service.CommandPostService;
import org.example.made4u.core.domain.post.service.UpdatePostService;
import org.example.made4u.core.domain.post.usecase.CreatePostUseCase;
import org.example.made4u.core.domain.post.usecase.SearchProductionUseCase;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostWebAdapter {
    private final CommandPostService commendPostService;
    private final UpdatePostService updatePostService;
    private final CreatePostUseCase createPostUseCase;
    private final SearchProductionUseCase searchProductionUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePostResponse createPost(@RequestPart(name = "body") CreatePostRequest request, @RequestPart(name = "file", required = false) MultipartFile file) {
        return createPostUseCase.execute(request, file);
    }

    // 비활성화
    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable String postId) {
        commendPostService.deletePost(postId);
    }

    // 비활성화
    @PatchMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@PathVariable String postId, @RequestBody UpdatePostRequest request) {
        updatePostService.updatePost(postId, request);
    }

    @GetMapping("/load/{keyword}")
    @ResponseStatus(HttpStatus.OK)
    public SearchProductionResponse getProductList(@PathVariable String keyword) {
        return searchProductionUseCase.execute(keyword);
    }
}
