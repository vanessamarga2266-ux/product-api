package com.ucr.product_api.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
