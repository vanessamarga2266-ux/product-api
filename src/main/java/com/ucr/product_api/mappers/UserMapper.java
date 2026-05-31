package com.ucr.product_api.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.ucr.product_api.Entities.User;
import com.ucr.product_api.dtos.UserDto;
import com.ucr.product_api.models.UserResponseModel;

@Component
public class UserMapper {

    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        /*
         * Si tienen un error en estos métodos, revisar la clase y verificar que los
         * nombres tengan la primera letra en mayúscula
         * o verificar que se llame correctamente
         */
        return new UserDto(user.getId(), user.getFullName(), user.getEmail(), user.getPassword(), user.getRole(),
                user.getCreatedAt());
    }

    public List<UserDto> toUserDtoList(List<User> users) {
        if (users == null) {
            return null;
        }

        return users.stream()
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }

    public UserResponseModel toUserResponseModel(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        return new UserResponseModel(userDto.id(), userDto.fullName(), userDto.email(), userDto.password(),
                userDto.role(), userDto.createdAt());
    }

    public List<UserResponseModel> toUserResponseModelList(List<UserDto> userDtos) {
        if (userDtos == null) {
            return null;
        }

        return userDtos.stream()
                .map(this::toUserResponseModel)
                .collect(Collectors.toList());
    }
}
