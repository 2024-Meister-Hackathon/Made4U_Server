package org.example.made4u.core.domain.buy.service;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.persistence.user.entity.PurchaseDetailJpaEntity;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.PurchaseDetailJpaRepository;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindPurchaseDataService {
    private final SecurityService securityService;
    private final UserJpaRepository userRepository;
    private final PurchaseDetailJpaRepository purchaseDetailJpaRepository;


    public List<PurchaseDetailJpaEntity> getData() {
        UserJpaEntity user = userRepository.findByEmail(securityService.getCurrentUserEmail())
                .orElseThrow(() -> UserNotExistException.EXCEPTION);

        return purchaseDetailJpaRepository.findAllByUser(user);
    }
}
