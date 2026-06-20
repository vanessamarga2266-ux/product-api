package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.Entities.Product;
import com.ucr.product_api.dtos.ProductRequestDto;
import com.ucr.product_api.exceptions.ProductNotFoundException;
import com.ucr.product_api.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product create(Product product) {
        if (product.getResourceId() == null) {
            product.setResourceId(UUID.randomUUID());
        }
        return productRepository.save(product);
    }

    @Override
    public Product addProduct(ProductRequestDto productDto) {
        var product = Product
        .builder()
        .name(productDto.getName())
        .description(productDto.getDescription())
        .price(productDto.getPrice())
        .resourceId(UUID.randomUUID())
        .build();

        return productRepository.addProduct(product);
    }

    @Override
    public Product updateProduct(UUID resourceId, ProductRequestDto productDto) {
        var product = productRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new ProductNotFoundException("Product no encontrado"));

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        return productRepository.updateProduct(product);
    }

    @Override
    public Product getByResourceId(UUID resourceId) {
        return productRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new ProductNotFoundException("Product no encontrado con resourceId"));
    }

    @Override
    public void removeProduct(UUID resourceId) {
        var product = productRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new ProductNotFoundException("Product no encontrado"));

        productRepository.delete(product);
    }
}