package com.ucr.product_api.repositories;

import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.ucr.product_api.Entities.Client;
 
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    default List<Client> getAll() {
 
        return findAll();
    }
}