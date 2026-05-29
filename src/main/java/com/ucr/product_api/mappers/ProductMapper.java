package com.ucr.product_api.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.ucr.product_api.Entities.Product;
import com.ucr.product_api.dtos.ProductDto;
import com.ucr.product_api.models.ProductResponseModel;

@Component
public class ProductMapper {

    public ProductDto toProductDto(Product product) {
        if (product == null) {
            return null;
        }
/* Si tienen un error en estos métodos, revisar la clase y verificar que los nombres tengan la primera letra en mayúscula
    o verificar que se llame correctamente */
        return new ProductDto(product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductDto> toProductDtoList(List<Product> products) {
        if (products == null) {
            return null;
        }

        return products.stream()
                .map(this::toProductDto)
                .collect(Collectors.toList());
    }

    public ProductResponseModel toProductResponseModel(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }

        return new ProductResponseModel(productDto.name(), productDto.description(), productDto.price());
    }
    public List<ProductResponseModel> toProductResponseModelList(List<ProductDto> productDtos) {
    if (productDtos == null) {
        return null;
    }

    return productDtos.stream()
        .map(this::toProductResponseModel)
        .collect(Collectors.toList());
}
}
