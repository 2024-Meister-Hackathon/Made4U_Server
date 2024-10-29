package org.example.made4u.core.domain.post.dto.reqeust;

public record CreatePostRequest(
        String title,
        String contents,
        String[] tags
) {
}
