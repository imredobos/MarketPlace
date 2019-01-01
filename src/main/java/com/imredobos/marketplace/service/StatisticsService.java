package com.imredobos.marketplace.service;

import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.repository.ProductRepository;
import com.imredobos.marketplace.repository.SaleRepository;
import com.imredobos.marketplace.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticsService {

    private ProductRepository productRepository;

    private SellerRepository sellerRepository;

    private SaleRepository saleRepository;

    @Autowired
    public StatisticsService(ProductRepository productRepository, SellerRepository sellerRepository, SaleRepository saleRepository) {
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
        this.saleRepository = saleRepository;
    }

    public List<Product> getAllProductsWithSalesData() {
        return productRepository.findAllProductsWithSales();
    }

    public List<Product> getAllProductsWithSalesDataOrderBySales(String sortDirection) {
        if ("desc".equals(sortDirection)) {
            return productRepository.findAllProductsWithSalesOrderBySalesDesc();
        } else {
            return productRepository.findAllProductsWithSalesOrderBySalesAsc();
        }
    }

    public List<Seller> getAllSellersWithSalesData() {
        return sellerRepository.findAllSellerWithSales();
    }

    public List<Seller> getSellerByAvgRating(String direction) {
        if ("desc".equals(direction)) {
            return sellerRepository.findAllSellerOrderByAvgRatingDesc();
        }
        return sellerRepository.findAllSellerOrderByAvgRatingAsc();
    }

    public List<Seller> getTop5SellersByTotalSalesValue() {
        return sellerRepository.findTop5SellersByTotalSalesValue().stream().limit(5).collect(Collectors.toList());
    }

    public List<Product> getTop5ProductByQueryCount() {
        return productRepository.findTop5ByQueryCount().stream().limit(5).collect(Collectors.toList());
    }

    public List<Map<String, Integer>> getSalesPerProductCategory() {
        return saleRepository.findTotalSalesPerProductCategory();
    }
}
