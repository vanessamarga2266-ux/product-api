package com.ucr.product_api.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.product_api.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    default List<Product> getAll() {
        return findAll();
    }

    default Product addProduct(Product product) {
        return save(product);
    }

    Optional<Product> findByResourceId(UUID resourceId);

    default Product updateProduct(Product product) {
        return save(product);
    }
}
