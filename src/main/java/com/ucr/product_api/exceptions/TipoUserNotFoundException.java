package com.ucr.product_api.exceptions;

public class TipoUserNotFoundException extends RuntimeException {
    public TipoUserNotFoundException(String message){
        super(message);
    }
}