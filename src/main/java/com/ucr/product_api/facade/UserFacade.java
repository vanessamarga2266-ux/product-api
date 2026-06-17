package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.product_api.dtos.UserDto;
import com.ucr.product_api.dtos.UserRequestDto;
import com.ucr.product_api.mappers.UserMapper;
import com.ucr.product_api.services.IUserServices;

import jakarta.transaction.Transactional;

@Component
public class UserFacade implements IUserFacade {

    @Autowired
    private IUserServices userServices;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> getAll() {
        return userMapper.toUserDtoList(userServices.getAll());
    }

    @Override
    public UserDto create(UserDto userDto) {
        com.ucr.product_api.Entities.User user = userMapper.toUserEntity(userDto);
        com.ucr.product_api.Entities.User saved = userServices.create(user);

        return userMapper.toUserDto(saved);
    }

    @Override
    public UserDto addUser(UserRequestDto userDto) {
        var entity = userServices.addUser(userDto);
        return userMapper.toUserDto(entity);
    }

    @Override
    @Transactional
    public UserDto updateUser(UUID resourceId, UserRequestDto user) {
        var entity = userServices.updateUser(resourceId, user);
        return userMapper.toUserDto(entity);
    }

    @Override
    public UserDto getByResourceId(UUID resourceId) {
        var entity = userServices.getByResourceId(resourceId);
        return userMapper.toUserDto(entity);
    }

    @Override
    @Transactional
    public void removeUser(UUID resourceId) {
        userServices.removeUser(resourceId);
    }
}