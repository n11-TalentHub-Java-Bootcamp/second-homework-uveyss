package com.example.converter;


import com.example.dto.ProductDetailDto;
import com.example.dto.ProductDto;
import com.example.entity.ProductEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {
    ProductConverter INSTANCE= Mappers.getMapper(ProductConverter.class);

   // @Mapping(source ="categoryId",target = "category.categoryId")
    ProductEntity convertProductDtoToProductEntity(ProductDto productDto);


    //@Mapping(source ="category.categoryId",target = "categoryId")
    ProductDto convertProdcutEntityToProdductDto(ProductEntity productEntity);


    //@Mapping(source ="category.categoryName",target = "categoryName")
    ProductDetailDto convertProductEntityToPtoductDetail(ProductEntity productEntity);

    @Mapping(source ="categoryId",target = "category.categoryId")
    List<ProductDto> convertProductEntityToProductDtoList(List<ProductEntity> productEntityList);
    /*
    * Null gelirse entity içerisinde boş entity oluşturulmaması için yazıldı.
    * */
    @AfterMapping
    default void seNull(@MappingTarget final ProductEntity productEntity,ProductDto productDto)
    {
        if(productDto.getCategoryId()==null)
        {
            productEntity.setCategory(null);
        }
    }

}
