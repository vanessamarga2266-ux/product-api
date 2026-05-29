package com.ucr.product_api.facade;
import java.util.List;

import com.ucr.product_api.dtos.ProductDto;

public interface IProductFacade {
    List<ProductDto> getAll();
}