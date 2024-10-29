package org.example.made4u.core.domain.user.exception;

import org.example.made4u.infrastructure.exception.BusinessException;
import org.example.made4u.infrastructure.exception.ErrorCode;

public class UserNotExistException extends BusinessException {
    public static UserNotExistException EXCEPTION = new UserNotExistException();

    public UserNotExistException() { super(ErrorCode.USER_NOT_FOUND); }
}
