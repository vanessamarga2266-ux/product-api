package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.Product;
import com.ucr.product_api.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}