package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ucr.product_api.Entities.User;
import com.ucr.product_api.dtos.UserRequestDto;
import com.ucr.product_api.exceptions.UserNotFoundException;
import com.ucr.product_api.repositories.UserRepository;

@Service
public class UserService implements IUserServices {
 
    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
 
    @Override
    public List<User> getAll() {
 
        return userRepository.getAll();
    }

    @Override
    public User create(User user) {
        if (user.getResourceId() == null) {
            user.setResourceId(UUID.randomUUID());
        }
        return userRepository.save(user);
    }

    @Override
    public User addUser(UserRequestDto userDto) {
        User user = User.builder()
                .tipoUserId(userDto.getTipoUserId())
                .fullName(userDto.getFullName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phone(userDto.getPhone())
                .resourceId(UUID.randomUUID())
                .build();

        return userRepository.addUser(user);
    }

    @Override
    public User updateUser(UUID resourceId, UserRequestDto userDto) {
        var user = userRepository.findByResourceId(resourceId)
        .orElseThrow(() -> new UserNotFoundException("User no encontrado"));

        user.setTipoUserId(userDto.getTipoUserId());
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());

        return userRepository.updateUser(user);
    }

    @Override
    public User getByResourceId(UUID resourceId) {
        return userRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new UserNotFoundException("User no encontrado con resourceId"));
    }

    @Override
    public void removeUser(UUID resourceId) {
       var user = userRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new UserNotFoundException("User no encontrado"));

        userRepository.delete(user);
    }
}