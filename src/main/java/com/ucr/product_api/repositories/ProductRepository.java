package com.ucr.product_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.product_api.Entities.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {
    default List<Product> findAll() {
        return findAll();
    }
}
