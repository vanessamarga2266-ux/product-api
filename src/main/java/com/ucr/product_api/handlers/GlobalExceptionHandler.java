package com.ucr.product_api.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ucr.product_api.dtos.ErrorDto;
import com.ucr.product_api.exceptions.TipoUserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleProductNotFound(
        TipoUserNotFoundException ex) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(
                        404,
                        ex.getMessage()
                ));
        }
}
