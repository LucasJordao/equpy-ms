package com.app.adapters.in.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CPFCNPJValidatorImpl.class)
public @interface CPFCNPJValidator {
    String message() default "CPF or CNPJ is not valid!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
