package com.app.adapters.in.handlers;

import com.app.adapters.in.responses.ErrorResponse;
import com.app.domain.exceptions.ErrorCode;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.time.LocalDateTime;
import java.util.List;

import static com.app.domain.exceptions.ErrorCode.INTERNAL_SERVER_ERROR;
import static com.app.domain.exceptions.ErrorCode.RESOURCE_NOT_FOUND_ERROR;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;


@Provider
@Slf4j
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {
    @Override
    @Produces(APPLICATION_JSON)
    public Response toResponse(Exception e) {

        if (e instanceof NotFoundException) {
            return this.buildResponse(RESOURCE_NOT_FOUND_ERROR, 404);
        }

        log.error(e.getMessage(), e);
        return this.buildResponse(INTERNAL_SERVER_ERROR, 500);
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
