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

        return new UserDto(
                user.getTipoUserId(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone(),
                user.getResourceId());
    }

    public List<UserDto> toUserDtoList(List<User> users){
        if (users == null) {
            return null;
        }

        return users.stream()
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }

    public UserResponseModel toUserResponseModel(UserDto userDto){
        if (userDto == null) {
            return null;
        }

        return new UserResponseModel(
                userDto.tipoUserId(),
                userDto.fullName(),
                userDto.email(),
                userDto.password(),
                userDto.phone(),
                userDto.resourceId());
    }

    public List<UserResponseModel> toUserResponseModelList(List<UserDto> userDtos){
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
        userDto.setFullName(user.name());
        userDto.setEmail(user.email());
        userDto.setPhone(user.phone());
        userDto.setPassword(user.password());
        userDto.setTipoUserId(user.tipoUserId());
        return userDto;
    }

    public User toUserEntity(UserRequestDto dto){
        if (dto == null) {
            return null;
        }

        return User.builder()
        .fullName(dto.getFullName())
        .email(dto.getEmail())
        .password(dto.getPassword())
        .phone(dto.getPhone())
        .tipoUserId(dto.getTipoUserId())
        .resourceId(UUID.randomUUID())
        .build();
    }

    public User toUserEntity(UserDto dto){
        if (dto == null) {
            return null;
        }

        return User.builder()
        .fullName(dto.fullName())
        .email(dto.email())
        .password(dto.password())
        .phone(dto.phone())
        .tipoUserId(dto.tipoUserId())
        .resourceId(dto.resourceId() == null ? UUID.randomUUID() : dto.resourceId())
        .build();
    }
}
