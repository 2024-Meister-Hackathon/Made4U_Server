package org.example.made4u.core.domain.buy.service;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.example.made4u.persistence.product.entity.ShoppingBagItemJpaEntity;
import org.example.made4u.persistence.product.repository.ProductJpaRepository;
import org.example.made4u.persistence.product.repository.ShoppingBagRepository;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommendShoppingItemService {
    private final SecurityService securityService;
    private final UserJpaRepository userRepository;
    private final ProductJpaRepository productRepository;
    private final ShoppingBagRepository shoppingBagRepository;

    public void createItem(String productId) {
        UserJpaEntity user = userRepository.findByEmail(securityService.getCurrentUserEmail())
                .orElseThrow(() -> UserNotExistException.EXCEPTION);
        ProductJpaEntity product = productRepository.findById(UUID.fromString(productId))
                .orElseThrow(RuntimeException::new);

        shoppingBagRepository.save(ShoppingBagItemJpaEntity.builder()
                        .product(product)
                        .user(user)
                        .build()
        );
    }

    public void deleteItem(String productId) {
        UserJpaEntity user = userRepository.findByEmail(securityService.getCurrentUserEmail())
                .orElseThrow(() -> UserNotExistException.EXCEPTION);
        ProductJpaEntity product = productRepository.findById(UUID.fromString(productId))
                .orElseThrow(RuntimeException::new);
        ShoppingBagItemJpaEntity item = shoppingBagRepository.findByUserAndProduct(user, product)
                .orElseThrow(RuntimeException::new);

        shoppingBagRepository.delete(item);
    }
}
