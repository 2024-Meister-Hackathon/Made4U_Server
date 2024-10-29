package org.example.made4u.core.domain.post.exception;

import org.example.made4u.infrastructure.exception.BusinessException;
import org.example.made4u.infrastructure.exception.ErrorCode;

public class DontHavePermissionPostException extends BusinessException {
    public static DontHavePermissionPostException EXCEPTION = new DontHavePermissionPostException();

    public DontHavePermissionPostException() { super(ErrorCode.DONT_HAVE_PERMISSION_POST); }
}
