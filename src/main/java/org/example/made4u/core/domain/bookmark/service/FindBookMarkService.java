package org.example.made4u.core.domain.bookmark.service;


import lombok.RequiredArgsConstructor;
import org.example.made4u.core.common.security.service.SecurityService;
import org.example.made4u.core.domain.bookmark.dto.response.BookMarkDto;
import org.example.made4u.core.domain.bookmark.dto.response.GetBookMarkResponse;
import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.persistence.post.entity.BookmarkJpaEntity;
import org.example.made4u.persistence.post.entity.PostJpaEntity;
import org.example.made4u.persistence.post.repository.BookmarkJpaRepository;
import org.example.made4u.persistence.post.repository.PostJpaRepository;
import org.example.made4u.persistence.user.entity.UserJpaEntity;
import org.example.made4u.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindBookMarkService {
    private final SecurityService securityService;
    private final UserJpaRepository userRepository;
    private final BookmarkJpaRepository bookmarkRepository;

    public final GetBookMarkResponse getBookmark () {
        UserJpaEntity user = userRepository.findByEmail(securityService.getCurrentUserEmail())
                .orElseThrow(() -> UserNotExistException.EXCEPTION);

        List<BookmarkJpaEntity> bookmarkList = bookmarkRepository.findAllByUser(user);

        List<BookMarkDto> bookMarkDto = new ArrayList<>();
        for (BookmarkJpaEntity bookmark : bookmarkList) {
            bookMarkDto.add(new BookMarkDto(
                    bookmark.getPost().getUser().getNickname(),
                    bookmark.getPost().getTitle(),
                    bookmark.getPost().getMainImg(),
                    bookmark.getPost().getUser().getProfile()
            ));
        }

        return new GetBookMarkResponse(bookMarkDto);
    }
}
