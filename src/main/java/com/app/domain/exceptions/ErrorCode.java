package com.app.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DATABASE_ERROR("MA002", "Internal Error."),
    USER_ALREADY_EXISTS_ERROR("MA003", "User already exists."),
    INTERNAL_SERVER_ERROR("MA004", "Internal server error."),
    USER_NOT_FOUND_ERROR("MA005", "User not found."),
    INVALID_CREDENTIALS("MA006", "Invalid credentials."),
    TOKEN_FLOW_ERROR("MA007", "Internal Error"),
    RESOURCE_NOT_FOUND_ERROR("MA008", "Resource not found.");

    private final String code;
    private final String message;
}
