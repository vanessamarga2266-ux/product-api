package com.ucr.product_api.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ucr.product_api.dtos.ErrorDto;
import com.ucr.product_api.exceptions.AttendanceNotFoundException;
import com.ucr.product_api.exceptions.MembershipNotFoundException;
import com.ucr.product_api.exceptions.ProductNotFoundException;
import com.ucr.product_api.exceptions.ScheduleNotFoundException;
import com.ucr.product_api.exceptions.TipoUserNotFoundException;
import com.ucr.product_api.exceptions.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleTipoUserNotFound(
        TipoUserNotFoundException ex) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(
                        404,
                        ex.getMessage()
                ));
        }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleAttendanceNotFound(
        AttendanceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(
                        404,
                        ex.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleMembershipNotFound(
        MembershipNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(
                        404,
                        ex.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleUserNotFound(
        UserNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(
                        404,
                        ex.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleProductNotFound(
        ProductNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(
                        404,
                        ex.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleScheduleNotFound(
        ScheduleNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(
                        404,
                        ex.getMessage()));
    }
}
