package com.app.domain.exceptions;

import static com.app.domain.exceptions.ErrorCode.DATABASE_ERROR;

public class DatabaseException extends BusinessException {
    public DatabaseException(String message) {
        super(DATABASE_ERROR, message);
    }
}
