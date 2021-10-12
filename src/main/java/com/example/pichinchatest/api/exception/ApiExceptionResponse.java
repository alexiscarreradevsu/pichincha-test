package com.example.pichinchatest.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiExceptionResponse {

    private LocalDateTime timestamp;

    private String description;

    private int status;
}
