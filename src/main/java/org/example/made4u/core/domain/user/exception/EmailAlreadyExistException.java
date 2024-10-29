package org.example.made4u.core.domain.user.exception;

import org.example.made4u.infrastructure.exception.BusinessException;
import org.example.made4u.infrastructure.exception.ErrorCode;

public class EmailAlreadyExistException extends BusinessException {
    public static EmailAlreadyExistException EXCEPTION = new EmailAlreadyExistException();

    public EmailAlreadyExistException() { super(ErrorCode.EMAIL_ALREADY_EXISTS); }
}
