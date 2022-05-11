package com.ifam.api_cliente.exceptions;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultExceptionModel {
    private int status;
    private String message;
    private ZonedDateTime timestamp;
}
