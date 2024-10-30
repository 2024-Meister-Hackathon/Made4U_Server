package org.example.made4u.persistence.post.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.example.made4u.persistence.user.entity.UserJpaEntity;

import java.util.UUID;

@Getter
@Builder
@IdClass(BookMarkId.class)
@Entity(name = "bookmark")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookmarkJpaEntity {

    @Id
    @ManyToOne(optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(referencedColumnName = "email", name = "email", nullable = false)
    private UserJpaEntity user;

    @Id
    @ManyToOne(optional = false, targetEntity = PostJpaEntity.class)
    @JoinColumn(referencedColumnName = "postId", name = "postId", nullable = false)
    private PostJpaEntity post;
}
