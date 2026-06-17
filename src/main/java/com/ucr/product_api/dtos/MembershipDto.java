package com.ucr.product_api.dtos;

import java.util.UUID;

public record MembershipDto(
      UUID resourceId,
      String name,
      String description,
      Double price,
      Integer durationDays
) {
}