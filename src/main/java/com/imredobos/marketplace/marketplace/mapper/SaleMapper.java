package com.imredobos.marketplace.marketplace.mapper;

import com.imredobos.marketplace.marketplace.dto.SaleDTO;
import com.imredobos.marketplace.marketplace.entity.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    Sale mapToEntity(SaleDTO saleDTO);

    SaleDTO mapToDTO(Sale sale);
}
