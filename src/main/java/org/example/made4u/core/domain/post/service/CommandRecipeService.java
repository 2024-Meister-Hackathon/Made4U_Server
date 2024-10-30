package org.example.made4u.core.domain.post.service;

import org.example.made4u.core.domain.post.dto.reqeust.RecipeDto;
import org.example.made4u.persistence.post.entity.PostJpaEntity;

import java.util.List;

public interface CommandRecipeService {

    void createRecipe(PostJpaEntity post, List<RecipeDto> recipes);
}
