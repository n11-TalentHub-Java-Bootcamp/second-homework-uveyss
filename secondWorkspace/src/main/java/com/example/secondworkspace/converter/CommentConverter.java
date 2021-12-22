package com.example.converter;

import com.example.dto.ProductCommentDto;
import com.example.dto.UserDto;
import com.example.entity.ProductCommentEntity;
import com.example.entity.UserEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentConverter {
    CommentConverter INSTANCE = Mappers.getMapper(CommentConverter.class);

    @Mapping(source ="userId",target = "user.userId")
    @Mapping(source ="userName",target = "user.userName")
    ProductCommentEntity convertProductCommentDtoToProductCommentEntity(ProductCommentDto productCommentDto);

    @Mapping(source ="user.userId",target = "userId")
    @Mapping(source ="user.userName",target = "userName")
    ProductCommentDto convertProductEntityToProductCommentDto(ProductCommentEntity productCommentEntity);

    @Mapping(source ="userId",target = "user.userId")
    @Mapping(source ="productId",target = "product.productId")
    @Mapping(source ="userName",target = "user.userName")
    List<ProductCommentEntity>convertProductCommentDtoListToProductCommentEntityList(List<ProductCommentDto> commentDtos);

    @Mapping(source ="user.userId",target = "userId")
    @Mapping(source ="product.productId",target = "productId")
    @Mapping(source ="user.userName",target = "userName")
    List<ProductCommentDto>convertProductCommentEntityListToProductCommentDtoList(List<ProductCommentEntity> commentEntities);


    /*
     * Null gelirse entity içerisinde boş entity oluşturulmaması için yazıldı.
     * */
    @AfterMapping
    default void seNull(@MappingTarget final ProductCommentEntity productCommentEntity, ProductCommentDto productCommentDto)
    {
        if(productCommentDto.getProductId()==null)
        {
            productCommentEntity.setProduct(null);
        }
        if(productCommentDto.getUserId()==null && productCommentDto.getUserName()==null) {
            productCommentEntity.setUser(null);
        }
    }

}
