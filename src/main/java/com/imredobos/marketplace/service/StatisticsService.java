package com.imredobos.marketplace.service;

import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.util.SortDirection;

import java.util.List;
import java.util.Map;

public interface StatisticsService {
    List<Product> getAllProductsWithSalesData();

    List<Product> getAllProductsWithSalesDataOrderBySales(SortDirection sortDirection);

    List<Seller> getAllSellersWithSalesData();

    List<Seller> getSellerByAvgRating(SortDirection sortDirection);

    List<Seller> getTop5SellersByTotalSalesValue();

    List<Product> getTop5ProductByQueryCount();

    List<Map<String, Integer>> getSalesPerProductCategory();
}
