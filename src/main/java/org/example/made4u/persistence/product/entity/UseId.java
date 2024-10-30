package org.example.made4u.persistence.product.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.user.entity.UserJpaEntity;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UseId implements Serializable {

    private ProductJpaEntity product;

    private PostJpaEntity post;
}
