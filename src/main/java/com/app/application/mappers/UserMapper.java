package com.app.application.mappers;

import com.app.adapters.out.entities.UserEntity;
import com.app.domain.models.User;

import java.time.LocalDateTime;

import static com.app.application.utils.FormatUtils.getOnlyNumbers;

public class UserMapper {
    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
                .name(user.getName())
                .document(getOnlyNumbers(user.getDocument()))
                .email(user.getEmail())
                .contact(getOnlyNumbers(user.getContact()))
                .birthDate(user.getBirthDate())
                .profile(user.getProfile())
                .password(user.getPassword())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static User fromEntity(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .document(entity.getDocument())
                .contact(entity.getContact())
                .email(entity.getEmail())
                .profile(entity.getProfile())
                .birthDate(entity.getBirthDate())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .deletedAt(entity.getDeletedAt())
                .build();
    }
}
