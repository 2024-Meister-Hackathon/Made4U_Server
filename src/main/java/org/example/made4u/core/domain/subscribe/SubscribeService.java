package org.example.made4u.core.domain.subscribe;


import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.example.made4u.persistence.product.entity.SubscribeJpaEntity;
import org.example.made4u.persistence.product.repository.ProductJpaRepository;
import org.example.made4u.persistence.product.repository.SubscribeJpaRepository;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscribeService {
    private final SubscribeJpaRepository subscribeJpaRepository;
    private final SecurityService securityService;
    private final ProductJpaRepository productRepository;
    private final UserJpaRepository userRepository;

    public void addSubscribe(String productId) {
        UserJpaEntity user = userRepository.findByEmail(securityService.getCurrentUserEmail())
                .orElseThrow(() -> UserNotExistException.EXCEPTION);
        ProductJpaEntity product = productRepository.findById(UUID.fromString(productId))
                        .orElseThrow(RuntimeException::new);

        subscribeJpaRepository.save(SubscribeJpaEntity.builder()
                .user(user)
                .product(product)
                .build()
        );
    }

    public void delSubscribe(String productId) {
        UserJpaEntity user = userRepository.findByEmail(securityService.getCurrentUserEmail())
                .orElseThrow(() -> UserNotExistException.EXCEPTION);
        ProductJpaEntity product = productRepository.findById(UUID.fromString(productId))
                .orElseThrow(RuntimeException::new);
        SubscribeJpaEntity subscribe = subscribeJpaRepository.findByUserAndProduct(user, product)
                .orElseThrow(RuntimeException::new);

        subscribeJpaRepository.delete(subscribe);
    }
}
