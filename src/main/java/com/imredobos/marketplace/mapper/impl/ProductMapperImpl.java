package com.imredobos.marketplace.mapper.impl;

import com.imredobos.marketplace.dto.ProductDTO;
import com.imredobos.marketplace.dto.SaleDTO;
import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.entity.Sale;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

import com.imredobos.marketplace.mapper.CategoryMapper;
import com.imredobos.marketplace.mapper.ProductMapper;
import com.imredobos.marketplace.mapper.SaleMapper;
import com.imredobos.marketplace.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2018-12-31T12:25:39+0100",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private SaleMapper saleMapper;
    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public ProductDTO mapToDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setName( product.getName() );
        productDTO.setDescription( product.getDescription() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setCategory( categoryMapper.mapToDTO( product.getCategory() ) );
        productDTO.setSeller( sellerMapper.mapToDTO( product.getSeller() ) );
        productDTO.setStock( product.getStock() );
        productDTO.setSales( saleSetToSaleDTOSet( product.getSales() ) );
        productDTO.setQueryCount( product.getQueryCount() );

        return productDTO;
    }

    @Override
    public Product mapToEntity(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( productDTO.getName() );
        product.setDescription( productDTO.getDescription() );
        product.setPrice( productDTO.getPrice() );
        product.setCategory( categoryMapper.mapToEntity( productDTO.getCategory() ) );
        product.setSeller( sellerMapper.mapToEntity( productDTO.getSeller() ) );
        product.setStock( productDTO.getStock() );
        product.setSales( saleDTOSetToSaleSet( productDTO.getSales() ) );
        product.setQueryCount( productDTO.getQueryCount() );

        return product;
    }

    protected Set<SaleDTO> saleSetToSaleDTOSet(Set<Sale> set) {
        if ( set == null ) {
            return null;
        }

        Set<SaleDTO> set1 = new HashSet<SaleDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Sale sale : set ) {
            set1.add( saleMapper.mapToDTO( sale ) );
        }

        return set1;
    }

    protected Set<Sale> saleDTOSetToSaleSet(Set<SaleDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Sale> set1 = new HashSet<Sale>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( SaleDTO saleDTO : set ) {
            set1.add( saleMapper.mapToEntity( saleDTO ) );
        }

        return set1;
    }
}
