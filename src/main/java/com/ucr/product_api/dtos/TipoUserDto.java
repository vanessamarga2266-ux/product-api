package com.ucr.product_api.dtos;

import java.util.UUID;

public record TipoUserDto(
    UUID resourceId,
    String name,
    String description
) {
}