package org.example.made4u.core.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.post.repository.PostJpaRepository;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.example.made4u.persistence.product.entity.UseJpaEntity;
import org.example.made4u.persistence.product.repository.ProductJpaRepository;
import org.example.made4u.persistence.product.repository.UseJpaRepository;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class GetServiceImpl {
    private final PostJpaRepository postJpaRepository;
    private final UseJpaRepository useJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final SecurityService securityService;

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

    public List<PostJpaEntity> getRecommend() {
        UserJpaEntity user = userJpaRepository.findByEmail(securityService.getCurrentUserEmail())
                .orElseThrow(RuntimeException::new);
        List<PostJpaEntity> posts = postJpaRepository.findAll();

        List<PostJpaEntity> result = new ArrayList<>();
        for (PostJpaEntity post : posts) {
            List<UseJpaEntity> products = useJpaRepository.getAllByPost(post);

            Set<String> allergies = new HashSet<>();
            Set<String> region = new HashSet<>();
            Set<String> vegan = new HashSet<>();
            for (UseJpaEntity product : products) {
                Collections.addAll(allergies, product.getProduct().getAllergy().split(","));
                region.add(product.getProduct().getReligion());
                Collections.addAll(vegan, product.getProduct().getVegan().split(","));
            }

            String[] userAllergies = user.getAllergy().split(",");
            if (Arrays.stream(userAllergies).noneMatch(allergies::contains) &&
                !region.contains(user.getReligion().toString()) &&
                !vegan.contains(user.getVegetarian().toString())) {
                result.add(post);
            }

            if (result.size() > 9) break;
        }

        return result;
    }
}
