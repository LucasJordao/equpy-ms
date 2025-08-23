package com.app.application.usecases;

import com.app.domain.models.User;
import com.app.domain.ports.in.RegisterUserUseCase;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class RegisterUseCaseImpl implements RegisterUserUseCase {
    @Override
    public User register(User user) {
        log.info("start create user");

        return user;
    }
}
