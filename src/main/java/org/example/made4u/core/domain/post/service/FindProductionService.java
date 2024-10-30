package org.example.made4u.core.domain.post.service;

import org.example.made4u.persistence.product.entity.ProductJpaEntity;

import java.util.List;

public interface FindProductionService {
    ProductJpaEntity findProductionById(String id);

    List<ProductJpaEntity> findAllProductionNameLike(String keyword);
}
