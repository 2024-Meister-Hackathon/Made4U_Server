package org.example.made4u.infrastructure.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    TOKEN_PARSING_ERROR(500, "토큰 처리중 에러가 발생했습니다"),
    INTERNAL_SERVER_ERROR(500, "서버 오류");

    private final int errorCode;
    private final String errorStatus;
}
