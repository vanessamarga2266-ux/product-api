package com.ucr.product_api.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.ucr.product_api.Entities.User;
 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    default List<User> getAll() {
 
        return findAll();
    }

    default User addUser(User user){
        return save(user);
    }

    Optional<User> findByResourceId(UUID resourceId);

    default User updateUser(User user){
        return save(user);
    };
}