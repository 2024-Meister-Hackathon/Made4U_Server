package org.example.made4u.persistence.post.entity;


import jakarta.persistence.*;
import lombok.*;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@DynamicInsert
@DynamicUpdate
@Entity(name = "post")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostJpaEntity {

    @Id
    @Column(nullable = false)
    private UUID postId;

    @ManyToOne(optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(referencedColumnName = "email", name = "email")
    private UserJpaEntity user;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contents;

    @Column(nullable = false,  columnDefinition = "VARCHAR(50)")
    private String tags;

    @Column(columnDefinition = "VARCHAR(150)")
    private String mainImg;
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createAt;
}
