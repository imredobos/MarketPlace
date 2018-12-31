package com.imredobos.marketplace.mapper;

import com.imredobos.marketplace.dto.CategoryDTO;
import com.imredobos.marketplace.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @ValueMappings({
            @ValueMapping(source = "TOY", target = "TOY"),
            @ValueMapping(source = "VEGETABLE", target = "VEGETABLE"),
            @ValueMapping(source = "FRUIT", target = "FRUIT"),
            @ValueMapping(source = "BEVERAGE", target = "BEVERAGE"),
            @ValueMapping(source = "MEAT", target = "MEAT")
    })
    CategoryDTO mapToDTO(Category category);

    @ValueMappings({
            @ValueMapping(source = "TOY", target = "TOY"),
            @ValueMapping(source = "VEGETABLE", target = "VEGETABLE"),
            @ValueMapping(source = "FRUIT", target = "FRUIT"),
            @ValueMapping(source = "BEVERAGE", target = "BEVERAGE"),
            @ValueMapping(source = "MEAT", target = "MEAT")
    })
    Category mapToEntity(CategoryDTO categoryDTO);

}
