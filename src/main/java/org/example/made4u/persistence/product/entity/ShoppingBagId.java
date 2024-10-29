package org.example.made4u.persistence.product.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@AllArgsConstructor
public class ShoppingBagId implements Serializable {

    private String email;

    private UUID productId;
}
