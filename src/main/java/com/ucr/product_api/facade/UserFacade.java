package com.ucr.product_api.facade;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.product_api.dtos.UserDto;
import com.ucr.product_api.mappers.UserMapper;
import com.ucr.product_api.services.IUserService;
 
@Component
public class UserFacade implements IUserFacade {
 
    @Autowired
    private IUserService userService;
 
    @Autowired
    private UserMapper userMapper;
 
    @Override
    public List<UserDto> getAll() {
        return userMapper.toUserDtoList(userService.getAll());
    }
}
