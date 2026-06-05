package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.Entities.Product;
import com.ucr.product_api.dtos.ProductRequestDto;
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

    @Override
    public Product addProduct(ProductRequestDto productDto) {
       var product = Product
       .builder()
       .name(productDto.getName())
       .description(productDto.getDescription()
       .price(productDto.getPrice())
       .resourceId(UUID.randomUUID())
       .build();
       return productRepository.addProduct(product);

        



       )
    }
    
}