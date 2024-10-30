package org.example.made4u.core.domain.bookmark.dto.response;

import java.util.List;

public record GetBookMarkResponse(
        List<BookMarkDto> bookMarkList
) {}

