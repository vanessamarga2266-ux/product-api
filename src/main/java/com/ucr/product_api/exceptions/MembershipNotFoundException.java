package com.ucr.product_api.exceptions;

public class MembershipNotFoundException extends RuntimeException {
    public MembershipNotFoundException(String message){
        super(message);
    }
}