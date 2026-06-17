package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.Entities.User;
import com.ucr.product_api.dtos.UserRequestDto;

public interface IUserServices {
    List<User> getAll();

    public User create(User user);

    User addUser(UserRequestDto userDto);

    User updateUser(UUID resourceId, UserRequestDto userDto);

    User getByResourceId (UUID resourceId);

    void removeUser(UUID resourceId);
}