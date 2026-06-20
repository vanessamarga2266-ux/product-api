package com.ucr.product_api.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucr.product_api.dtos.ProductDto;
import com.ucr.product_api.facade.IProductFacade;
import com.ucr.product_api.mappers.ProductMapper;
import com.ucr.product_api.models.ProductRequestModel;
import com.ucr.product_api.models.ProductResponseModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductFacade productFacade;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping
     public ResponseEntity<List<ProductResponseModel>> findAll(){
        return ResponseEntity.ok(productMapper.toProductResponseModelList(productFacade.getAll()));
     }

    @PostMapping
    public ProductDto save(@RequestBody ProductRequestModel productRequestModel) {
        var dto = productMapper.toProductRequestDto(productRequestModel);

        return productFacade.addProduct(dto);
    }

    @PutMapping(path = "/{resourceId}")
    public ProductDto update(@PathVariable("resourceId") UUID resourceId,
            @RequestBody ProductRequestModel productRequestModel) {

        var dto = productMapper.toProductRequestDto(productRequestModel);

        return productFacade.updateProduct(resourceId, dto);
    }

    @GetMapping(path = "/{resourceId}")
    public ProductDto findById(@PathVariable("resourceId") UUID resourceId) {
        return productFacade.getByResourceId(resourceId);
    }

    @DeleteMapping(path = "/{resourceId}")
    public void remove(@PathVariable("resourceId") UUID resourceId) {
        productFacade.removeProduct(resourceId);
    }
}
