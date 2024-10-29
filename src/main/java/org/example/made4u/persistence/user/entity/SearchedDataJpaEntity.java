package org.example.made4u.persistence.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Entity(name = "searchData")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchedDataJpaEntity {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(referencedColumnName = "email", name = "email", nullable = false)
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String contents;
}
