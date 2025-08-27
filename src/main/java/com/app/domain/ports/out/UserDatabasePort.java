package com.app.domain.ports.out;

import com.app.adapters.out.entities.UserEntity;

import java.util.Optional;

public interface UserDatabasePort {
    UserEntity createUser(UserEntity entity);

    Optional<UserEntity> findByEmail(String email);
}
