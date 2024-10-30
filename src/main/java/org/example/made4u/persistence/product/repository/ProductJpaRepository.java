package org.example.made4u.persistence.product.repository;

import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductJpaRepository extends CrudRepository<ProductJpaEntity, UUID> {

}
