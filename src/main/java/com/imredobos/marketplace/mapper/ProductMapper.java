package com.imredobos.marketplace.mapper;

import com.imredobos.marketplace.dto.ProductDTO;
import com.imredobos.marketplace.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {
                CategoryMapper.class,
                SaleMapper.class,
                SellerMapper.class
        })
public interface ProductMapper {

    ProductDTO mapToDTO(Product product);

    Product mapToEntity(ProductDTO productDTO);
}
