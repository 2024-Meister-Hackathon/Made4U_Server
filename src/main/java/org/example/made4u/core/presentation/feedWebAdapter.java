package org.example.made4u.core.presentation;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.feed.service.GetServiceImpl;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class feedWebAdapter {

    private final GetServiceImpl getService;

    @GetMapping("/time/{order}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<PostJpaEntity> getByTime(@PathVariable String order) {
        return getService.getByTime(order);
    }

    @GetMapping("/recommend")
    @ResponseStatus(HttpStatus.CREATED)
    public List<PostJpaEntity> getRecommend() {
        return getService.getRecommend();
    }

    @GetMapping("/keyword/{keyword}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<PostJpaEntity> getByKeyword(@PathVariable String keyword) {
        return getService.getByKeyword(keyword);
    }
}
