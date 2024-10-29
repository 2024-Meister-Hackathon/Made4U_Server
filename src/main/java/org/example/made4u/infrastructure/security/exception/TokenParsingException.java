package org.example.made4u.infrastructure.security.exception;

import org.example.made4u.infrastructure.exception.BusinessException;
import org.example.made4u.infrastructure.exception.ErrorCode;

public class TokenParsingException extends BusinessException {
    public static TokenParsingException EXCEPTION = new TokenParsingException();

    public TokenParsingException() { super(ErrorCode.TOKEN_PARSING_ERROR); }
}
