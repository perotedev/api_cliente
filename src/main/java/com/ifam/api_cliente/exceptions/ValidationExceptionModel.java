package com.ifam.api_cliente.exceptions;

import java.time.ZonedDateTime;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationExceptionModel {
    private int status;
    private ZonedDateTime timestamp;
    private List errosList;
}
