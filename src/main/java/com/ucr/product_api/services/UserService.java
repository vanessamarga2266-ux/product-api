package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.User;
import com.ucr.product_api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService implements IUserServices {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}