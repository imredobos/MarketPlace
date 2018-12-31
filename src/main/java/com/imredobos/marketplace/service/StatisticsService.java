package com.imredobos.marketplace.service;

import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.repository.ProductRepository;
import com.imredobos.marketplace.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    private ProductRepository productRepository;

    private SellerRepository sellerRepository;

    @Autowired
    public StatisticsService(ProductRepository productRepository, SellerRepository sellerRepository) {
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
    }

    public List<Product> getAllProductsWithSalesData() {
        return productRepository.findAllProductsWithSales();
    }

    public List<Product> getAllProductsWithSalesDataOrderBySales(Sort sort) {
        return productRepository.findAllProductsWithSalesOrderBySales(sort);
    }

    public List<Seller> getAllSellersWithSalesData() {
        return sellerRepository.findAllSellerWithSales();
    }
}
