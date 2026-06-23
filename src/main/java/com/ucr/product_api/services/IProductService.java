package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.Entities.Product;
import com.ucr.product_api.dtos.ProductRequestDto;

public interface IProductService {
    List<Product> getAll();

    Product create(Product product);

    Product addProduct(ProductRequestDto productDto);

    Product updateProduct(UUID resourceId, ProductRequestDto productDto);

    Product getByResourceId(UUID resourceId);

    void removeProduct(UUID resourceId);
}
