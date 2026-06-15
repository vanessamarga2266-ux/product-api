package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.Product;
import com.ucr.product_api.dtos.ProductRequestDto;

public interface IProductService {
    List<Product> getAll();

    Product addProduct(ProductRequestDto productDto);
}
