package com.ifam.api_cliente.domain.exceptions;

import java.time.ZonedDateTime;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class AppExceptionHandler extends RuntimeException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity handleValidationException(MethodArgumentNotValidException ex) {

        List<FieldError> fieldErrors = ex.getFieldErrors();

        List<String> responseErros = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            responseErros.add(fieldError.getDefaultMessage());
        }

        ValidationExceptionModel error = new ValidationExceptionModel(HttpStatus.BAD_REQUEST.value(),
                ZonedDateTime.now(), responseErros);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    
    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity handleNoSuchElementException(NoSuchElementException ex) {
        DefaultExceptionModel error = new DefaultExceptionModel(HttpStatus.NOT_FOUND.value(),
                "Cliente não encontrado", ZonedDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // @ExceptionHandler(TransactionSystemException.class)
    // private ResponseEntity handleTransactionSystemException(TransactionSystemException ex) {
    //     DefaultExceptionModel error = new DefaultExceptionModel(HttpStatus.UNPROCESSABLE_ENTITY.value(),
    //             ex.getMessage(), ZonedDateTime.now());

    //     return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    // }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity handleConstraintViolationException(DataIntegrityViolationException ex) {
        DefaultExceptionModel error = new DefaultExceptionModel(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "CPF já está sendo utilizado", ZonedDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    private ResponseEntity handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        DefaultExceptionModel error = new DefaultExceptionModel(HttpStatus.NOT_FOUND.value(),
                "Cliente não encontrado", ZonedDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity handleException(Exception ex) {
        DefaultExceptionModel error = new DefaultExceptionModel(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(), ZonedDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}