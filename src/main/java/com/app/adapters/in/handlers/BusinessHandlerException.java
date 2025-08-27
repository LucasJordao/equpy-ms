package com.app.adapters.in.handlers;

import com.app.adapters.in.responses.ErrorResponse;
import com.app.domain.exceptions.BusinessException;
import com.app.domain.exceptions.ErrorCode;
import com.app.domain.exceptions.UserAlreadyExistsException;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Provider
@Slf4j
public class BusinessHandlerException implements ExceptionMapper<BusinessException> {

    @Override
    @Produces(APPLICATION_JSON)
    public Response toResponse(BusinessException e) {
        log.error("Error in business flow. Error [{}]", e.getMessage());

        if (e instanceof UserAlreadyExistsException) {
            return this.buildResponse(e.getError(), 422);
        }

        return this.buildResponse(e.getError(), 500);
    }

    private Response buildResponse(ErrorCode error, Integer statusCode) {
        return Response.status(statusCode)
                .entity(
                        ErrorResponse.builder()
                                .code(error.getCode())
                                .correlationId(MDC.get("correlationId"))
                                .messages(List.of(error.getMessage()))
                                .timestamp(LocalDateTime.now())
                                .build()
                )
                .build();
    }
}
