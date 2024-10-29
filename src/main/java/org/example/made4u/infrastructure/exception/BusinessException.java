package org.example.made4u.infrastructure.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BusinessException extends RuntimeException {
    public final ErrorCode errorCode;
}
