package com.ucr.product_api.facade;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.product_api.dtos.ProductDto;
import com.ucr.product_api.mappers.ProductMapper;
import com.ucr.product_api.services.IProductService;
 
@Component
public class ProductFacade implements IProductFacade {
 
    @Autowired
    private IProductService productService;
 
    @Autowired
    private ProductMapper productMapper;
 
    @Override
    public List<ProductDto> getAll() {
        return productMapper.toProductDtoList(productService.getAll());
    }
}
