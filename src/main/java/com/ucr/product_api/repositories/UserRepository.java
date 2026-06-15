package com.ucr.product_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.product_api.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    default List<User> getAll() {
        return findAll();
    }
}