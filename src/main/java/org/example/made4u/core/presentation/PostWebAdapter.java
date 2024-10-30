package org.example.made4u.core.presentation;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.post.dto.reqeust.CreatePostRequest;
import org.example.made4u.core.domain.post.dto.reqeust.UpdatePostRequest;
import org.example.made4u.core.domain.post.dto.response.CreatePostResponse;
import org.example.made4u.core.domain.post.service.CommendPostService;
import org.example.made4u.core.domain.post.service.UpdatePostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostWebAdapter {
    private final CommendPostService commendPostService;
    private final UpdatePostService updatePostService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePostResponse createPost(@RequestPart(name = "body") CreatePostRequest request, @RequestPart(name = "file", required = false) MultipartFile file) {
        return commendPostService.createPost(request, file);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable String postId) {
        commendPostService.deletePost(postId);
    }

    @PatchMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@PathVariable String postId, @RequestBody UpdatePostRequest request) {
        updatePostService.updatePost(postId, request);
    }
}
