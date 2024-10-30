package org.example.made4u.persistence.product.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.made4u.persistence.user.entity.UserJpaEntity;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SubscribeId implements Serializable {

    private UserJpaEntity user;

    private ProductJpaEntity product;
}
