package com.imredobos.marketplace.mapper;

import com.imredobos.marketplace.dto.SaleDTO;
import com.imredobos.marketplace.entity.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = ProductMapper.class)
public interface SaleMapper {

    Sale mapToEntity(SaleDTO saleDTO);

    SaleDTO mapToDTO(Sale sale);
}
