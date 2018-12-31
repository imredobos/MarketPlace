package com.imredobos.marketplace.mapper.impl;

import com.imredobos.marketplace.dto.SaleDTO;
import com.imredobos.marketplace.entity.Sale;
import javax.annotation.Generated;

import com.imredobos.marketplace.mapper.ProductMapper;
import com.imredobos.marketplace.mapper.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2018-12-31T12:25:39+0100",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class SaleMapperImpl implements SaleMapper {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Sale mapToEntity(SaleDTO saleDTO) {
        if ( saleDTO == null ) {
            return null;
        }

        Sale sale = new Sale();

        sale.setProduct( productMapper.mapToEntity( saleDTO.getProduct() ) );
        sale.setUnit( saleDTO.getUnit() );
        sale.setValue( saleDTO.getValue() );
        sale.setDate( saleDTO.getDate() );

        return sale;
    }

    @Override
    public SaleDTO mapToDTO(Sale sale) {
        if ( sale == null ) {
            return null;
        }

        SaleDTO saleDTO = new SaleDTO();

        saleDTO.setId( sale.getId() );
        saleDTO.setProduct( productMapper.mapToDTO( sale.getProduct() ) );
        saleDTO.setUnit( sale.getUnit() );
        saleDTO.setValue( sale.getValue() );
        saleDTO.setDate( sale.getDate() );

        return saleDTO;
    }
}
