package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.User;

public interface IUserService {
    List<User> getAll();
}
