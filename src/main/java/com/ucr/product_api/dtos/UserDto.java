package com.ucr.product_api.dtos;

import java.util.UUID;

public record UserDto(

        Integer tipoUserId,

        String fullName,

        String email,

        String password,

        String phone,

        UUID resourceId) {
}