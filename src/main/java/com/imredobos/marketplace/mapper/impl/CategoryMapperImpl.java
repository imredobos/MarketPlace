package com.imredobos.marketplace.mapper.impl;

import com.imredobos.marketplace.dto.CategoryDTO;
import com.imredobos.marketplace.entity.Category;
import javax.annotation.Generated;

import com.imredobos.marketplace.mapper.CategoryMapper;
import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2018-12-31T12:25:39+0100",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO mapToDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO;

        switch ( category ) {
            case TOY: categoryDTO = CategoryDTO.TOY;
                break;
            case VEGETABLE: categoryDTO = CategoryDTO.VEGETABLE;
                break;
            case FRUIT: categoryDTO = CategoryDTO.FRUIT;
                break;
            case BEVERAGE: categoryDTO = CategoryDTO.BEVERAGE;
                break;
            case MEAT: categoryDTO = CategoryDTO.MEAT;
                break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + category );
        }

        return categoryDTO;
    }

    @Override
    public Category mapToEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category;

        switch ( categoryDTO ) {
            case TOY: category = Category.TOY;
                break;
            case VEGETABLE: category = Category.VEGETABLE;
                break;
            case FRUIT: category = Category.FRUIT;
                break;
            case BEVERAGE: category = Category.BEVERAGE;
                break;
            case MEAT: category = Category.MEAT;
                break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + categoryDTO );
        }

        return category;
    }
}
