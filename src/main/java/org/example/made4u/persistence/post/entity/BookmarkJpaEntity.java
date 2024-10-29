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
    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(referencedColumnName = "email", name = "email", nullable = false)
    private String email;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = PostJpaEntity.class)
    @JoinColumn(referencedColumnName = "postId", name = "postId", nullable = false)
    private UUID postId;
}
