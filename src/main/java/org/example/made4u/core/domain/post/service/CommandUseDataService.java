package org.example.made4u.core.domain.post.service;

import org.example.made4u.persistence.post.entity.PostJpaEntity;

public interface CommandUseDataService {

    void createUseData(String[] UUIDData, PostJpaEntity post);
}
