package org.example.made4u.infrastructure.thirdparty.s3.exception;

import org.example.made4u.core.domain.user.exception.PasswordMismatchException;
import org.example.made4u.infrastructure.exception.BusinessException;
import org.example.made4u.infrastructure.exception.ErrorCode;

public class FileIOException extends BusinessException {
    public static FileIOException EXCEPTION = new FileIOException();

    public FileIOException() { super(ErrorCode.PASSWORD_MISMATCHES); }
}
