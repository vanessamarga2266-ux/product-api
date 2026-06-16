package com.ucr.product_api.exceptions;

public class AttendanceNotFoundException extends RuntimeException {

    public AttendanceNotFoundException(String message) {
        super(message);
    }
}
