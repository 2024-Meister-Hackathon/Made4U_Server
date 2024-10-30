package org.example.made4u.persistence.user.repository;

import org.example.made4u.persistence.user.entity.PurchaseDetailJpaEntity;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseDetailJpaRepository extends CrudRepository<PurchaseDetailJpaEntity, String> {

    List<PurchaseDetailJpaEntity> findAllByUser(UserJpaEntity user);
}
