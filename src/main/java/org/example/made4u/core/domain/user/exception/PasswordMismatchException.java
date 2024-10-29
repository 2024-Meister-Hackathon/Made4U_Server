package org.example.made4u.core.domain.user.exception;

import org.example.made4u.infrastructure.exception.BusinessException;
import org.example.made4u.infrastructure.exception.ErrorCode;

public class PasswordMismatchException extends BusinessException {
    public static PasswordMismatchException EXCEPTION = new PasswordMismatchException();

    public PasswordMismatchException() { super(ErrorCode.PASSWORD_MISMATCHES); }
}
