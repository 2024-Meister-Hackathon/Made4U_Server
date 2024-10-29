package org.example.made4u.infrastructure.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // user
    PASSWORD_MISMATCHES(401, "비밀번호가 일치하지 않습니다."),
    USER_NOT_FOUND(404, "존재하지 않는 유저입니다."),
    EMAIL_ALREADY_EXISTS(409, "이미 가입된 이메일입니다."),

    FILE_IO_ERROR(500, "파일 업로드/불러오는 과정중 에러가 발생했습니다"),
    TOKEN_PARSING_ERROR(500, "토큰 처리중 에러가 발생했습니다"),
    INTERNAL_SERVER_ERROR(500, "서버 오류");

    private final int errorCode;
    private final String errorStatus;
}
