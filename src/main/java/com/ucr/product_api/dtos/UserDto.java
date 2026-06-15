package com.ucr.product_api.dtos;

public record UserDto(
        long id,
        Integer tipoUserId,
        String fullName,
        String email,
        String password,
        String phone
        ){
}