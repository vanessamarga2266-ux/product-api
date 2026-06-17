package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.dtos.UserDto;
import com.ucr.product_api.dtos.UserRequestDto;

public interface IUserFacade {
    List<UserDto> getAll();
    public UserDto create(UserDto userDto);
    UserDto addUser(UserRequestDto userDto);
    UserDto updateUser(UUID resourceId, UserRequestDto user);
    UserDto getByResourceId(UUID resourceId);
    void removeUser(UUID resourceId);
}