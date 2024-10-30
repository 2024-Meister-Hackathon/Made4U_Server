package org.example.made4u.core.presentation;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.bookmark.dto.response.GetBookMarkResponse;
import org.example.made4u.core.domain.bookmark.service.CommendBookmarkService;
import org.example.made4u.core.domain.bookmark.service.FindBookMarkService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmark")
public class BookmarkWebAdapter {
    private final CommendBookmarkService commendBookmarkService;
    private final FindBookMarkService findBookMarkService;


    @PostMapping("/{postId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBookmark(@PathVariable String postId) {
        commendBookmarkService.createBookmark(postId);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delBookmark(@PathVariable String postId) {
        commendBookmarkService.deleteBookmark(postId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetBookMarkResponse getBookmark() {
        return findBookMarkService.getBookmark();
    }
}
