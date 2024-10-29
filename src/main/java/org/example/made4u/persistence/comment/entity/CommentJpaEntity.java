package org.example.made4u.persistence.comment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.example.made4u.persistence.user.entity.UserJpaEntity;

import java.util.UUID;

@Getter
@Builder
@Entity(name = "comment")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentJpaEntity {

    @Id
    @Column(nullable = false)
    private UUID commentId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = PostJpaEntity.class)
    @JoinColumn(referencedColumnName = "postId", name = "postId")
    private UUID postId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(referencedColumnName = "email", name = "email")
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    private String contents;
}
