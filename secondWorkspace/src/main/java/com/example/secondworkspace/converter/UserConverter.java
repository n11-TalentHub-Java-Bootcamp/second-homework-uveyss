package com.example.converter;

import com.example.dto.ProductDto;
import com.example.dto.UserDto;
import com.example.entity.ProductEntity;
import com.example.entity.UserEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDto userEntityConvertToUserDto(UserEntity entity);

    UserEntity userDtoConvertToUserEntity(UserDto userDto);

    List<UserDto> userEntityListConvertToUserDto(List<UserEntity> userEntities);


    List<UserEntity> userDtoListConvertToUserEntityList(List<UserDto> userDtoList);


}
