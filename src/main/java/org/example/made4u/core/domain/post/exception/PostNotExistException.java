package org.example.made4u.core.domain.post.exception;

import org.example.made4u.core.domain.user.exception.UserNotExistException;
import org.example.made4u.infrastructure.exception.BusinessException;
import org.example.made4u.infrastructure.exception.ErrorCode;

public class PostNotExistException extends BusinessException {
    public static PostNotExistException EXCEPTION = new PostNotExistException();

    public PostNotExistException() { super(ErrorCode.POST_NOT_EXISTS); }
}
