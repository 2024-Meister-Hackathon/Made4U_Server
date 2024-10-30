package org.example.made4u.core.domain.post.service;

import org.example.made4u.core.domain.post.dto.reqeust.CreatePostRequest;
import org.example.made4u.core.domain.post.dto.response.CreatePostResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CommendPostService {

    CreatePostResponse createPost(CreatePostRequest request, MultipartFile file);

    void deletePost(String postId);
}
