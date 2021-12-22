package com.example.converter;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import com.example.dto.CategoryDto;
import com.example.entity.CategoryEntity;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);


    CategoryDto convertCategoryDto(CategoryEntity categoryEntity);
}
