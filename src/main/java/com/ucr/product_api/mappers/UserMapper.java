package com.ucr.product_api.mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.product_api.Entities.User;
import com.ucr.product_api.dtos.UserDto;
import com.ucr.product_api.dtos.UserRequestDto;
import com.ucr.product_api.models.UserRequestModel;
import com.ucr.product_api.models.UserResponseModel;

@Component
public class UserMapper {
    
    public UserDto toUserDto(User user){
        if (user == null) {
            return null;
        }

        return new UserDto(user.getResourceId(), user.getName(), user.getDescription());
    }

    public List<UserDto> toUserDtoList(List<User> users){
        if (users == null) {
            return null;
        }

        return users.stream()
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }

    public UserResponseModel toUserResponseModel(UserRequestDto userDto){
        if (userDto == null) {
            return null;
        }

        return new UserResponseModel(userDto.resourceId(), userDto.name(), userDto.description());
    }

    public List<UserResponseModel> toUserResponseModelList(List<UserRequestDto> userDtos){
        if (userDtos == null) {
            return null;
        }

        return userDtos.stream()
                .map(this::toUserResponseModel)
                .collect(Collectors.toList());
    }

    public UserRequestDto toUserRequestDto(UserRequestModel user){
        if (user == null) {
            return null;
        }

        UserRequestDto userDto = new UserRequestDto();
        userDto.setName(user.name());
        userDto.setDescription(user.description());
        return userDto;
    }

    public User toUserEntity(UserRequestDto dto){
        if (dto == null) {
            return null;
        }

        UUID resourceId = dto.resourceId() == null ? UUID.randomUUID() : dto.resourceId();

        return User.builder()
        .name(dto.name())
        .description(dto.description())
        .resourceId(resourceId)
        .build();
    }
}