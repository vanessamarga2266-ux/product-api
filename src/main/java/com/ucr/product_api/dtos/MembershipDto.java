package com.ucr.product_api.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record MembershipDto(
    UUID resourceId,
    String name,
    String description,
    BigDecimal price,
    Integer durationDays
) {}