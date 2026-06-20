package com.ucr.product_api.facade;
import java.util.List;
import java.util.UUID;

import com.ucr.product_api.dtos.ProductDto;
import com.ucr.product_api.dtos.ProductRequestDto;

public interface IProductFacade {
    List<ProductDto> getAll();
    ProductDto create(ProductDto productDto);
    ProductDto addProduct(ProductRequestDto productDto);
    ProductDto updateProduct(UUID resourceId, ProductRequestDto productDto);
    ProductDto getByResourceId(UUID resourceId);
    void removeProduct(UUID resourceId);
}