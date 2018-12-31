package com.imredobos.marketplace.mapper;

import com.imredobos.marketplace.dto.SellerDTO;
import com.imredobos.marketplace.entity.Seller;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {
                ProductMapper.class,
                RateMapper.class
        })
public interface SellerMapper {
    Seller mapToEntity(SellerDTO sellerDTO);

    SellerDTO mapToDTO(Seller seller);
}
