package org.example.made4u.core.domain.post.exception;

import org.example.made4u.infrastructure.exception.BusinessException;
import org.example.made4u.infrastructure.exception.ErrorCode;

public class ProductionNotExistException extends BusinessException {
    public static ProductionNotExistException EXCEPTION = new ProductionNotExistException();

    public ProductionNotExistException() { super(ErrorCode.POST_NOT_EXISTS); }
}
