package com.imredobos.marketplace.mapper.impl;

import com.imredobos.marketplace.dto.ProductDTO;
import com.imredobos.marketplace.dto.RateDTO;
import com.imredobos.marketplace.dto.SellerDTO;
import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.entity.Rate;
import com.imredobos.marketplace.entity.Seller;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

import com.imredobos.marketplace.mapper.ProductMapper;
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
public class SellerMapperImpl implements SellerMapper {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private RateMapper rateMapper;

    @Override
    public Seller mapToEntity(SellerDTO sellerDTO) {
        if ( sellerDTO == null ) {
            return null;
        }

        Seller seller = new Seller();

        seller.setFirstName( sellerDTO.getFirstName() );
        seller.setLastName( sellerDTO.getLastName() );
        seller.setEmail( sellerDTO.getEmail() );

        return seller;
    }

    @Override
    public SellerDTO mapToDTO(Seller seller) {
        if ( seller == null ) {
            return null;
        }

        SellerDTO sellerDTO = new SellerDTO();

        sellerDTO.setId( seller.getId() );
        sellerDTO.setFirstName( seller.getFirstName() );
        sellerDTO.setLastName( seller.getLastName() );
        sellerDTO.setEmail( seller.getEmail() );

        return sellerDTO;
    }

    protected Set<Product> productDTOSetToProductSet(Set<ProductDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Product> set1 = new HashSet<Product>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ProductDTO productDTO : set ) {
            set1.add( productMapper.mapToEntity( productDTO ) );
        }

        return set1;
    }

    protected Set<Rate> rateDTOSetToRateSet(Set<RateDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Rate> set1 = new HashSet<Rate>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RateDTO rateDTO : set ) {
            set1.add( rateMapper.mapToEntity( rateDTO ) );
        }

        return set1;
    }

    protected Set<ProductDTO> productSetToProductDTOSet(Set<Product> set) {
        if ( set == null ) {
            return null;
        }

        Set<ProductDTO> set1 = new HashSet<ProductDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Product product : set ) {
            set1.add( productMapper.mapToDTO( product ) );
        }

        return set1;
    }

    protected Set<RateDTO> rateSetToRateDTOSet(Set<Rate> set) {
        if ( set == null ) {
            return null;
        }

        Set<RateDTO> set1 = new HashSet<RateDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Rate rate : set ) {
            set1.add( rateMapper.mapToDTO( rate ) );
        }

        return set1;
    }
}
