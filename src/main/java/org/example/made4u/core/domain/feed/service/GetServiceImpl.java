package org.example.made4u.core.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.post.repository.PostJpaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetServiceImpl {
    private final PostJpaRepository postJpaRepository;

    public List<PostJpaEntity> getByTime(String order) {
        if (order.equals("DESC")) {
            return postJpaRepository.findAll(Sort.by("createAt").descending());
        } else if (order.equals("ASC")) {
            return postJpaRepository.findAll(Sort.by("createAt").ascending());
        } else {
            throw new RuntimeException();
        }
    };

    public List<PostJpaEntity> getByKeyword(String keyword) {
        return postJpaRepository.searchByKeyword(keyword);
    };
}
