package org.example.made4u.persistence.product.repository;

import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.example.made4u.persistence.product.entity.UseId;
import org.example.made4u.persistence.product.entity.UseJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UseJpaRepository extends CrudRepository<UseJpaEntity, UseId> {

    Boolean existsByPostAndProduct(PostJpaEntity post, ProductJpaEntity product);

    List<UseJpaEntity> getAllByPost(PostJpaEntity post);
}
