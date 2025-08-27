package com.app.adapters.out.entities;

import com.app.application.utils.CryptoUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.TemporalType.*;

@Data
@Builder
@Entity
@Table(name = "tb_users")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "document")
    private String document;
    @Column(name = "contact")
    private String contact;
    @Column(name = "password")
    private String password;
    @Temporal(DATE)
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "profile")
    private String profile;
    @Column(name = "roles")
    private List<String> roles;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public void encryptValues(CryptoUtil cryptoUtil) {
        if(document != null && !document.isBlank()) {
            document = cryptoUtil.encrypt(document);
        }

        if(contact != null && !contact.isBlank()) {
            contact = cryptoUtil.encrypt(contact);
        }
    }
}
