package com.imredobos.marketplace.marketplace.service;

import com.imredobos.marketplace.marketplace.entity.Product;
import com.imredobos.marketplace.marketplace.entity.Seller;
import com.imredobos.marketplace.marketplace.repository.ProductRepository;
import com.imredobos.marketplace.marketplace.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public List<Product> getAllProductsWithSalesData() {
        return productRepository.findAllProductWithSales();
    }

    public List<Product> getAllProductsWithSalesDataOrderBySales(Sort sort) {
        return productRepository.findAllProductWithSalesOrderBySales(sort);
    }

    public List<Seller> getAllSellersWithSalesData() {
        return sellerRepository.findAllSellerWithSales();
    }
}
