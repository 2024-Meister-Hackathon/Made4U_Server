package org.example.made4u.core.domain.buy.service;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.persistence.product.entity.ShoppingBagItemJpaEntity;
import org.example.made4u.persistence.product.repository.ShoppingBagRepository;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindShoppingItemService {
    private final SecurityService securityService;
    private final UserJpaRepository userRepository;
    private final ShoppingBagRepository shoppingBagRepository;


    public List<ShoppingBagItemJpaEntity> getItems() {
        UserJpaEntity user = userRepository.findByEmail(securityService.getCurrentUserEmail())
                .orElseThrow(() -> UserNotExistException.EXCEPTION);

        return shoppingBagRepository.findAllByUser(user);
    }
}
