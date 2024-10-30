package org.example.made4u.core.domain.post.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.post.dto.reqeust.RecipeDto;
import org.example.made4u.core.domain.post.service.CommandRecipeService;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.post.entity.RecipeJpaEntity;
import org.example.made4u.persistence.post.repository.RecipeJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandRecipeServiceImpl implements CommandRecipeService {
    private final RecipeJpaRepository recipeJpaRepository;

    @Override
    public void createRecipe(PostJpaEntity post, List<RecipeDto> recipes) {
        for (RecipeDto recipe : recipes) {
            recipeJpaRepository.save(RecipeJpaEntity.builder()
                    .post(post)
                    .idx(recipe.idx())
                    .recipeId(UUID.randomUUID())
                    .contents(recipe.contents())
                    .build()
            );
        }
    }
}
