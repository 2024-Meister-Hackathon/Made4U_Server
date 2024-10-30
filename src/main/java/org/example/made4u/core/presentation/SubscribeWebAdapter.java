package org.example.made4u.core.presentation;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.subscribe.SubscribeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscribe")
public class SubscribeWebAdapter {
    private final SubscribeService subscribeService;

    @PostMapping("/add/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSubscribe(@PathVariable String productId) {
        subscribeService.addSubscribe(productId);
    }

    @DeleteMapping("/del/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubscribe(@PathVariable String productId) {
        subscribeService.delSubscribe(productId);
    }
}
