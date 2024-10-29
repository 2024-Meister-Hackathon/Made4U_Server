package org.example.made4u.infrastructure.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> businessExceptionHandler(BusinessException e) {
        ErrorCode errorCode = e.errorCode;
        ExceptionResponse response = ExceptionResponse.of(errorCode.getErrorCode(), errorCode.getErrorStatus());

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(errorCode.getErrorCode()));
    }

//    @ExceptionHandler
//    public ResponseEntity<ExceptionResponse> RuntimeExceptionHandler(RuntimeException e) {
//        System.out.println(e.getCause());
//
//        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
//        ExceptionResponse response = ExceptionResponse.of(errorCode.getErrorCode(), errorCode.getErrorStatus(), e.getMessage());
//
//        return new ResponseEntity<>(response, HttpStatusCode.valueOf(errorCode.getErrorCode()));
//    }
}
