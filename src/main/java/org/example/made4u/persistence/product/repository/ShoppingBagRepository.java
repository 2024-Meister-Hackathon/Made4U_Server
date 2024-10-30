package org.example.made4u.persistence.product.repository;

import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.example.made4u.persistence.product.entity.ShoppingBagId;
import org.example.made4u.persistence.product.entity.ShoppingBagItemJpaEntity;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingBagRepository extends CrudRepository<ShoppingBagItemJpaEntity, ShoppingBagId> {

    Optional<ShoppingBagItemJpaEntity> findByUserAndProduct(UserJpaEntity user, ProductJpaEntity product);

    List<ShoppingBagItemJpaEntity> findAllByUser(UserJpaEntity user);
}
