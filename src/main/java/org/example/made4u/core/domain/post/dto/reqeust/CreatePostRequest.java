package org.example.made4u.core.domain.post.dto.reqeust;

import java.util.List;
import java.util.UUID;

public record CreatePostRequest(
        String title,
        String contents,
        String[] tags,
        String[] ingredients,
        String[] sauce,
        List<RecipeDto> recipe
) {
}
