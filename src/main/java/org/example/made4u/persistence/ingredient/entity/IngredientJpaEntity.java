package org.example.made4u.persistence.ingredient.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Builder
@Entity(name = "ingredient")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IngredientJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String name;


    @Enumerated(EnumType.STRING)
    @ColumnDefault("'NONE'")
    @Column(nullable = false)
    private Allergy allergy;
}
