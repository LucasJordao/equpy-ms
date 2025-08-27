package com.app.adapters.in.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private String code;
    private List<String> messages;
    private LocalDateTime timestamp;
    private String correlationId;
}
