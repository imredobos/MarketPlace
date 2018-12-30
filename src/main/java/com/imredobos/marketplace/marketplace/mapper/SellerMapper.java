package com.imredobos.marketplace.marketplace.mapper;

import com.imredobos.marketplace.marketplace.dto.SellerDTO;
import com.imredobos.marketplace.marketplace.entity.Seller;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellerMapper {
    Seller mapToEntity(SellerDTO sellerDTO);

    SellerDTO mapToDTO(Seller seller);
}
