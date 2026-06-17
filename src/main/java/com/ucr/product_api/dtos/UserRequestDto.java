package com.ucr.product_api.dtos;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private Integer tipoUserId;

    private String fullName;

    private String email;

    private String password;

    private String phone;

}
