package org.example.made4u.persistence.user.entity;


import jakarta.persistence.*;
import lombok.*;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;

import java.util.UUID;

@Getter
@Builder
@Entity(name = "purchaseDetail")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PurchaseDetailJpaEntity {

    @Id
    @Column(nullable = false)
    private UUID purchaseId;

    @ManyToOne(optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(referencedColumnName = "email", name = "email", nullable = false)
    private UserJpaEntity user;

    @ManyToOne(optional = false, targetEntity = ProductJpaEntity.class)
    @JoinColumn(referencedColumnName = "productId", name = "productId", nullable = false)
    private ProductJpaEntity product;
}
