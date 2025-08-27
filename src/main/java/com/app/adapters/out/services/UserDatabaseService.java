package com.app.adapters.out.services;

import com.app.adapters.out.entities.UserEntity;
import com.app.domain.exceptions.DatabaseException;
import com.app.domain.ports.out.UserDatabasePort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Optional;

import static com.app.adapters.out.entities.UserEntity.find;
import static com.app.adapters.out.entities.UserEntity.persist;

@ApplicationScoped
public class UserDatabaseService implements UserDatabasePort {
    @Override
    @Transactional
    public UserEntity createUser(UserEntity entity) {
        try {
            persist(entity);

            return entity;
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        try {
            return Optional.ofNullable(find("email = ?1", email).firstResult());
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
