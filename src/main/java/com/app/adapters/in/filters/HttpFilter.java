package com.app.adapters.in.filters;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;

@Provider
@Slf4j
public class HttpFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String correlationId = requestContext.getHeaderString("X-Correlation-Id");

        if(correlationId == null || correlationId.isEmpty()) {
            log.info("Correlation ID not found, generating a new one");
            correlationId = UUID.randomUUID().toString();
        }

        MDC.put("correlationId", correlationId);
    }
}
