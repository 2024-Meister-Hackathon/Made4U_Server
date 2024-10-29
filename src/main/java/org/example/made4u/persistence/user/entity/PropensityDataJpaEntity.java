package org.example.made4u.persistence.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Entity(name = "propensityDetail")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PropensityDataJpaEntity {

    @Id
    @OneToOne(cascade = CascadeType.ALL, optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(referencedColumnName = "email", name = "email")
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String tend;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String favor;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean isVegetarian;
}
