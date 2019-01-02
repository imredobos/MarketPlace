package com.imredobos.marketplace.service.impl;

import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.repository.ProductRepository;
import com.imredobos.marketplace.repository.SaleRepository;
import com.imredobos.marketplace.repository.SellerRepository;
import com.imredobos.marketplace.service.StatisticsService;
import com.imredobos.marketplace.util.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private ProductRepository productRepository;

    private SellerRepository sellerRepository;

    private SaleRepository saleRepository;

    @Autowired
    public StatisticsServiceImpl(ProductRepository productRepository, SellerRepository sellerRepository, SaleRepository saleRepository) {
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Product> getAllProductsWithSalesData() {
        return productRepository.findAllProductsWithSales();
    }

    @Override
    public List<Product> getAllProductsWithSalesDataOrderBySales(SortDirection sortDirection) {
        if (sortDirection.equals(SortDirection.DESCENDING)) {
            return productRepository.findAllProductsWithSalesOrderBySalesDesc();
        } else {
            return productRepository.findAllProductsWithSalesOrderBySalesAsc();
        }
    }

    @Override
    public List<Seller> getAllSellersWithSalesData() {
        return sellerRepository.findAllSellersWithSales();
    }

    @Override
    public List<Seller> getSellerByAvgRating(SortDirection sortDirection) {
        if (sortDirection.equals(SortDirection.DESCENDING)) {
            return sellerRepository.findAllSellersOrderByAvgRatingDesc();
        } else {
            return sellerRepository.findAllSellersOrderByAvgRatingAsc();
        }
    }

    @Override
    public List<Seller> getTop5SellersByTotalSalesValue() {
        return sellerRepository.findTop5SellersByTotalSalesValue().stream().limit(5).collect(Collectors.toList());
    }

    @Override
    public List<Product> getTop5ProductByQueryCount() {
        return productRepository.findTop5ByQueryCount().stream().limit(5).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Integer>> getSalesPerProductCategory() {
        return saleRepository.findTotalSalesPerProductCategory();
    }
}
