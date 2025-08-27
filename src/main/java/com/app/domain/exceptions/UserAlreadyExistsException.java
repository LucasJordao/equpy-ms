package com.app.domain.exceptions;

import static com.app.domain.exceptions.ErrorCode.USER_ALREADY_EXISTS_ERROR;

public class UserAlreadyExistsException extends BusinessException {
    public UserAlreadyExistsException(String message) {
        super(USER_ALREADY_EXISTS_ERROR, message);
    }
}
