package com.app.adapters.in.handlers;

import com.app.adapters.in.responses.ErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.app.domain.exceptions.ErrorCode.VALIDATION_ERROR;

@Slf4j
@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>();

        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errors.add(violation.getMessage());
        }

        return Response.status(400)
                .entity(
                        ErrorResponse.builder()
                                .code(VALIDATION_ERROR.getCode())
                                .correlationId(MDC.get("correlationId"))
                                .messages(errors)
                                .timestamp(LocalDateTime.now())
                                .build()
                )
                .build();
    }
}
