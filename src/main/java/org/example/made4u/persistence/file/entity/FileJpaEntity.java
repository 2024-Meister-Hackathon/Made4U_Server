package org.example.made4u.persistence.file.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.made4u.persistence.ingredient.entity.IngredientJpaEntity;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;

import java.util.UUID;

@Getter
@Builder
@Entity(name = "file")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileJpaEntity {

    @Id
    @Column(nullable = false)
    private String fileName;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = PostJpaEntity.class)
    @JoinColumn(referencedColumnName = "postId", name = "postId")
    private UUID postId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = ProductJpaEntity.class)
    @JoinColumn(referencedColumnName = "productId", name = "productId")
    private UUID productId;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String url;
}
