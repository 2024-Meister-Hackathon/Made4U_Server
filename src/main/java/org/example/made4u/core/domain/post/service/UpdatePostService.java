package org.example.made4u.core.domain.post.service;

import org.example.made4u.core.domain.post.dto.reqeust.UpdatePostRequest;

public interface UpdatePostService {

    void updatePost(String postId, UpdatePostRequest request);
}
