package org.example.made4u.persistence.post.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Builder
@Entity(name = "post")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostJpaEntity {

    @Id
    @Column(nullable = false)
    private UUID postId;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contents;

    @Column(nullable = false,  columnDefinition = "VARCHAR(50)")
    private String tag;
}
