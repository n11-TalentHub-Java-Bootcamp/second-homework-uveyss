package com.example.controller;



import com.example.converter.ProductConverter;
import com.example.dto.ProductDetailDto;
import com.example.dto.ProductDto;
import com.example.entity.ProductEntity;
import com.example.entityService.CategoryEntityService;
import com.example.entity.ProductEntity;
import com.example.entityService.ProductEntityService;
import com.example.exceptionHandler.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductEntityService productEntityService;

    @GetMapping("")
    public List<ProductDto> findAllProducts()
    {
        List<ProductEntity> productEntityList = productEntityService.findAllProduct();
        List<ProductDto> productDtoList = ProductConverter.INSTANCE.convertProductEntityToProductDtoList(productEntityList);
        return productDtoList;
    }

    @GetMapping("/{id}")
    public ProductDetailDto findProductById(@PathVariable Long productId)
    {
        ProductEntity productEntity=productEntityService.findProductById(productId);
        if (productEntity==null)
        {
            throw new ProductNotFoundException("Urun not found. id: " + productId);
        }
        WebMvcLinkBuilder linkToUrun = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAllProducts()
        );
        return  new ProductDetailDto();
    }
}
