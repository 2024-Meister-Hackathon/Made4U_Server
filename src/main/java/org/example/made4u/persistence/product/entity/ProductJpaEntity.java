package org.example.made4u.persistence.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Builder
@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductJpaEntity {

    @Id
    @Column(nullable = false)
    private UUID productId;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String allergy;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String religion;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String vegan;
}
