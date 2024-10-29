package org.example.made4u.core.domain.post.service;

import org.example.made4u.core.domain.post.dto.reqeust.CreatePostRequest;
import org.example.made4u.core.domain.post.dto.response.CreatePostResponse;

public interface CommendPostService {

    CreatePostResponse createPost(CreatePostRequest request);

    void deletePost(String postId);
}
