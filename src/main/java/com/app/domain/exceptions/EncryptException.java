package com.app.domain.exceptions;

import static com.app.domain.exceptions.ErrorCode.ENCRYPT_ERROR;

public class EncryptException extends BusinessException {
    public EncryptException(String message) {
        super(ENCRYPT_ERROR, message);
    }
}
