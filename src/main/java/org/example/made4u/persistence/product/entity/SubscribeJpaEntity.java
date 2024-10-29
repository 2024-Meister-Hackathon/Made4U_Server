package org.example.made4u.persistence.product.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.made4u.persistence.user.entity.UserJpaEntity;

import java.util.UUID;

@Getter
@Builder
@IdClass(SubscribeId.class)
@Entity(name = "subscribe")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SubscribeJpaEntity {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(referencedColumnName = "email", name = "email", nullable = false)
    private String email;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = ProductJpaEntity.class)
    @JoinColumn(referencedColumnName = "productId", name = "productId", nullable = false)
    private UUID productId;
}
