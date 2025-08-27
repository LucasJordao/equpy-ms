package com.app.adapters.in.mappers;

import com.app.adapters.in.requests.UserRequest;
import com.app.domain.models.User;

public class UserRequestMapper {
    public static User toUser(UserRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .document(request.getDocument())
                .password(request.getPassword())
                .build();
    }
}
