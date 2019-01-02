package com.imredobos.marketplace.controller;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.entity.view.View;
import com.imredobos.marketplace.service.StatisticsService;
import com.imredobos.marketplace.util.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stats")
public class StatisticsController {

    private StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    //  Listing products with sales data (sales unit and value)
    @JsonView(View.WithSales.class)
    @GetMapping("/products")
    public List<Product> getAllProductsWithSalesData() {
        return statisticsService.getAllProductsWithSalesData();
    }


    //	Ordering list of products by sales (parametrized request: ascending or descending)
    @JsonView(View.Summary.class)
    @GetMapping("/products/order")
    public List<Product> getProductBySalesOrder(@RequestParam("dir") String direction) {
        SortDirection sortDirection = SortDirection.getDirection(direction);
        return statisticsService.getAllProductsWithSalesDataOrderBySales(sortDirection);
    }

    //	Listing sellers with their sales data (sales unit and value)
    @JsonView(View.WithProductAndSales.class)
    @GetMapping("/sellers")
    public List<Seller> getSellersWithSalesData() {
        return statisticsService.getAllSellersWithSalesData();
    }

    // Ordering list of sellers by average rating (parametrized request: ascending or descending)
    @GetMapping("/top-sellers/avg")
    @JsonView(View.Summary.class)
    public List<Seller> getSellerByAvgRating(@RequestParam("dir") String direction) {
        SortDirection sortDirection = SortDirection.getDirection(direction);
        return statisticsService.getSellerByAvgRating(sortDirection);
    }

    //	Listing top 5 sellers by total sales value
    @GetMapping("/top-sellers/total-value")
    @JsonView(View.Summary.class)
    public List<Seller> getTop5SellersByTotalSalesValue() {
        return statisticsService.getTop5SellersByTotalSalesValue();
    }

    //	Listing top 5 most viewed products
    @GetMapping("/top-sellers/most-viewed")
    @JsonView(View.Summary.class)
    public List<Product> getTop5ProductByQueryCount() {
        return statisticsService.getTop5ProductByQueryCount();
    }


    //	Total sales per product category
    @GetMapping("/sales")
    @JsonPropertyOrder({"category, totalSales"})
    public List<Map<String, Integer>> getSalesPerProductCategory() {
        return statisticsService.getSalesPerProductCategory();
    }

}
