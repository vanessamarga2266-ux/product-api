package com.ucr.product_api.dtos;

public record ErrorDto(
    int status,
    String message) {
}