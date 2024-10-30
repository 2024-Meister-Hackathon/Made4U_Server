package org.example.made4u.persistence.product.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.user.entity.UserJpaEntity;

@Getter
@Builder
@IdClass(UseId.class)
@Entity(name = "useData")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UseJpaEntity {

    @Id
    @ManyToOne(optional = false, targetEntity = ProductJpaEntity.class)
    @JoinColumn(referencedColumnName = "productId", name = "productId", nullable = false)
    private ProductJpaEntity product;

    @Id
    @ManyToOne(optional = false, targetEntity = PostJpaEntity.class)
    @JoinColumn(referencedColumnName = "postId", name = "postId", nullable = false)
    private PostJpaEntity post;
}
