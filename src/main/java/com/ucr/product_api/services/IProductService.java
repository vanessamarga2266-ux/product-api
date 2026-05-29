package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.Product;

public interface IProductService {
    List<Product> getAll();
}
