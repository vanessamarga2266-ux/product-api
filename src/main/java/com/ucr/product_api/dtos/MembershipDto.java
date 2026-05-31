package com.ucr.product_api.dtos;

import java.math.BigDecimal;

public record MembershipDto(
      Long id,
      String name,
      String description,
      BigDecimal price,
      Integer durationDays) {

}
