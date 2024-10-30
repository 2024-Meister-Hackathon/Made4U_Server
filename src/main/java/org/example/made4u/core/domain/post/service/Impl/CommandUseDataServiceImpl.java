package org.example.made4u.core.domain.post.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.post.service.CommandUseDataService;
import org.example.made4u.core.domain.post.service.FindProductionService;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.example.made4u.persistence.product.entity.UseJpaEntity;
import org.example.made4u.persistence.product.repository.ProductJpaRepository;
import org.example.made4u.persistence.product.repository.UseJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandUseDataServiceImpl implements CommandUseDataService {
    private final UseJpaRepository useJpaRepository;
    private final FindProductionService findProductionService;

    @Override
    public void createUseData(String[] UUIDData, PostJpaEntity post) {
        for (String ingredientUUID : UUIDData) {
            ProductJpaEntity product = findProductionService.findProductionById(ingredientUUID);

            if (!useJpaRepository.existsByPostAndProduct(post, product)) {
                useJpaRepository.save(new UseJpaEntity(product, post));
            }
        }
    }
}
