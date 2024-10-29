package org.example.made4u.persistence.ingredient.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.example.made4u.persistence.user.entity.UserJpaEntity;

import java.util.UUID;

@Getter
@Builder
@Entity(name = "useData")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UseJpaEntity {

    @Id
    @Column(nullable = false)
    private String useId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = PostJpaEntity.class)
    @JoinColumn(referencedColumnName = "postId", name = "postId")
    private UUID postId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = ProductJpaEntity.class)
    @JoinColumn(referencedColumnName = "productId", name = "productId")
    private UUID productId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = IngredientJpaEntity.class)
    @JoinColumn(referencedColumnName = "name", name = "ingredient", nullable = false)
    private String ingredient;
}
