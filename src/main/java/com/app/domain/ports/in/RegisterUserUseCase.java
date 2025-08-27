package com.app.domain.ports.in;

import com.app.domain.models.User;

public interface RegisterUserUseCase {
    User register(User user);
}
