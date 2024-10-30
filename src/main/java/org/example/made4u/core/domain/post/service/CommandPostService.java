package org.example.made4u.core.domain.post.service;

import org.example.made4u.core.domain.post.dto.reqeust.CreatePostRequest;
import org.example.made4u.core.domain.post.dto.response.CreatePostResponse;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.springframework.web.multipart.MultipartFile;

public interface CommandPostService {

    void createPost(PostJpaEntity post);

    void deletePost(String postId);
}
