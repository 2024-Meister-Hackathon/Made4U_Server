package org.example.made4u.core.domain.post.dto.reqeust;

import java.util.Optional;

public record UpdatePostRequest(
        Optional<String> title,
        Optional<String> contents,
        Optional<String[]> tags
) {
}
