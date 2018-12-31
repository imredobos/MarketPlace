package com.imredobos.marketplace.mapper;

import com.imredobos.marketplace.dto.RateDTO;
import com.imredobos.marketplace.entity.Rate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = SellerMapper.class)
public interface RateMapper {

    RateDTO mapToDTO(Rate rate);

    Rate mapToEntity(RateDTO rateDTO);
}
