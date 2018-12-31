package com.imredobos.marketplace.mapper.impl;

import com.imredobos.marketplace.dto.RateDTO;
import com.imredobos.marketplace.entity.Rate;
import javax.annotation.Generated;

import com.imredobos.marketplace.mapper.RateMapper;
import com.imredobos.marketplace.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2018-12-31T12:25:38+0100",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class RateMapperImpl implements RateMapper {

    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public RateDTO mapToDTO(Rate rate) {
        if ( rate == null ) {
            return null;
        }

        RateDTO rateDTO = new RateDTO();

        rateDTO.setId( rate.getId() );
        rateDTO.setRating( rate.getRating() );
        rateDTO.setComment( rate.getComment() );
        rateDTO.setSeller( sellerMapper.mapToDTO( rate.getSeller() ) );

        return rateDTO;
    }

    @Override
    public Rate mapToEntity(RateDTO rateDTO) {
        if ( rateDTO == null ) {
            return null;
        }

        Rate rate = new Rate();

        rate.setRating( rateDTO.getRating() );
        rate.setComment( rateDTO.getComment() );
        rate.setSeller( sellerMapper.mapToEntity( rateDTO.getSeller() ) );

        return rate;
    }
}
