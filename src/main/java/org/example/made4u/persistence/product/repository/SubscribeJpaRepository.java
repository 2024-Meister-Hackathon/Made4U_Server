package org.example.made4u.persistence.product.repository;

import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.example.made4u.persistence.product.entity.SubscribeId;
import org.example.made4u.persistence.product.entity.SubscribeJpaEntity;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubscribeJpaRepository extends CrudRepository<SubscribeJpaEntity, SubscribeId> {

    Optional<SubscribeJpaEntity> findByUserAndProduct(UserJpaEntity user, ProductJpaEntity product);
}
