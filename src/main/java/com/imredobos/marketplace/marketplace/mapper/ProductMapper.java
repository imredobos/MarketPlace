package com.imredobos.marketplace.marketplace.mapper;

import com.imredobos.marketplace.marketplace.dto.ProductDTO;
import com.imredobos.marketplace.marketplace.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product mapToEntity(ProductDTO productDTO);

    ProductDTO mapToDTO(Product product);
}
