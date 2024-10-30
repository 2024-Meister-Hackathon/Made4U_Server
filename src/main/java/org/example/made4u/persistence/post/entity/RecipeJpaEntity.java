package org.example.made4u.persistence.post.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Builder
@Entity(name = "recipe")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecipeJpaEntity {
    @Id
    private UUID recipeId;

    @Column(nullable = false)
    private int idx;

    @ManyToOne(optional = false, targetEntity = PostJpaEntity.class)
    @JoinColumn(nullable = false, referencedColumnName = "postId", name = "postId")
    private PostJpaEntity post;

    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    private String contents;
}
