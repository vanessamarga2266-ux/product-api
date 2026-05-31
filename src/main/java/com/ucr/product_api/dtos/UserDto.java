package com.ucr.product_api.dtos;


import java.sql.Date;

public record UserDto(
        long id,
        String fullName,
        String email,
        String password,
        String role,
        Date createdAt) {

}
