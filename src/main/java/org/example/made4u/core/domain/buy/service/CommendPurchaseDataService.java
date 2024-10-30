package org.example.made4u.core.domain.buy.service;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.example.made4u.persistence.product.entity.ShoppingBagItemJpaEntity;
import org.example.made4u.persistence.product.repository.ProductJpaRepository;
import org.example.made4u.persistence.product.repository.ShoppingBagRepository;
import org.example.made4u.persistence.user.entity.PurchaseDetailJpaEntity;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.PurchaseDetailJpaRepository;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommendPurchaseDataService {
    private final SecurityService securityService;
    private final UserJpaRepository userRepository;
    private final ProductJpaRepository productRepository;
    private final ShoppingBagRepository shoppingBagRepository;
    private final PurchaseDetailJpaRepository purchaseDetailRepository;


    public void purchase() {
        UserJpaEntity user = userRepository.findByEmail(securityService.getCurrentUserEmail())
                .orElseThrow(() -> UserNotExistException.EXCEPTION);

        List<ShoppingBagItemJpaEntity> items = shoppingBagRepository.findAllByUser(user);

        for (ShoppingBagItemJpaEntity item : items) {
            ProductJpaEntity product = productRepository.findById(item.getProduct().getProductId())
                    .orElseThrow(RuntimeException::new);
            shoppingBagRepository.delete(item);

            purchaseDetailRepository.save(PurchaseDetailJpaEntity.builder()
                            .purchaseId(UUID.randomUUID())
                            .user(user)
                            .product(product)
                            .build()
            );
        }
    }
}
