package com.app.adapters.in.requests;

import com.app.adapters.in.validators.CPFCNPJValidator;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "Name is required!")
    @Size(min = 3, max = 50, message = "Name must have between 3 and 50 characters!")
    private String name;
    @Email(message = "Email is not valid!")
    @NotBlank(message = "Email is required!")
    private String email;
    @CPFCNPJValidator(message = "Document is not valid!")
    private String document;
    @NotBlank(message = "Password is required!")
    private String password;
}
