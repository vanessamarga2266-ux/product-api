package com.ucr.product_api.exceptions;

public class UserNotFoundexception extends RuntimeException {
    public UserNotFoundexception(String message){
        super(message);
    }
}