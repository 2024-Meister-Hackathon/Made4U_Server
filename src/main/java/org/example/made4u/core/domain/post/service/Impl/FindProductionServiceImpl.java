package org.example.made4u.core.domain.post.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.post.exception.ProductionNotExistException;
import org.example.made4u.core.domain.post.service.FindProductionService;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.example.made4u.persistence.product.repository.ProductJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class FindProductionServiceImpl implements FindProductionService {
    private final ProductJpaRepository productJpaRepository;

    @Override
    public ProductJpaEntity findProductionById(String id) {
        return productJpaRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> ProductionNotExistException.EXCEPTION
        );
    }

    @Override
    public List<ProductJpaEntity> findAllProductionNameLike(String keyword) {
        return productJpaRepository.findAllByNameLike(keyword);
    }
}
