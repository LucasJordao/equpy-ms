package com.app.application.usecases;

import com.app.application.utils.CryptoUtil;
import com.app.domain.exceptions.UserAlreadyExistsException;
import com.app.domain.models.User;
import com.app.domain.ports.in.RegisterUserUseCase;
import com.app.domain.ports.out.UserDatabasePort;
import jakarta.ws.rs.ext.Provider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.app.application.mappers.UserMapper.fromEntity;
import static com.app.application.mappers.UserMapper.toEntity;

@Slf4j
@Provider
@AllArgsConstructor
public class RegisterUseCaseImpl implements RegisterUserUseCase {
    private final UserDatabasePort userDatabase;
    private final CryptoUtil cryptoUtil;

    @Override
    public User register(User user) {
        log.info("start create user");

        var userFounded = userDatabase.findByEmail(user.getEmail());

        if(userFounded.isPresent()) {
            log.warn("User already exists by email");
            throw new UserAlreadyExistsException("User already exists.");
        }

        var entity = toEntity(user);

        entity.encryptValues(cryptoUtil);

        return fromEntity(userDatabase.createUser(entity));
    }
}
