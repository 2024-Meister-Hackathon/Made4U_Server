package org.example.made4u.infrastructure.exception;

import java.time.LocalDateTime;
import java.util.Date;

public record ExceptionResponse(
        int errorCode,
        String errorMessage,
        String description,
        LocalDateTime timeStamp
) {
    public static ExceptionResponse of (int errorCode, String errorMessage) {
        return new ExceptionResponse(errorCode, errorMessage, errorMessage, LocalDateTime.now());
    }

    public static ExceptionResponse of (int errorCode, String errorMessage, String description) {
        return new ExceptionResponse(errorCode, errorMessage, description, LocalDateTime.now());
    }
}
