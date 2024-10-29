package org.example.made4u.persistence.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Builder
@Getter
@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    private String password;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String nickname;

    @ColumnDefault("'DEFAULT_IMG_URL'") // todo: 기본 URL 정해지면 그걸로 변경
    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String profile;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'NONE'")
    @Column(nullable = false)
    private Membership membership;
}
