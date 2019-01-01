package com.imredobos.marketplace.controller;

import com.imredobos.marketplace.dto.ProductDTO;
import com.imredobos.marketplace.dto.SellerDTO;
import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.mapper.ProductMapper;
import com.imredobos.marketplace.mapper.SellerMapper;
import com.imredobos.marketplace.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stats")
public class StatisticsController {

    private StatisticsService statisticsService;

    private ProductMapper productMapper;

    private SellerMapper sellerMapper;

    @Autowired
    public StatisticsController(StatisticsService statisticsService, ProductMapper productMapper, SellerMapper sellerMapper) {
        this.statisticsService = statisticsService;
        this.productMapper = productMapper;
        this.sellerMapper = sellerMapper;
    }

    //  Listing products with sales data (sales unit and value)
    @GetMapping("/products")
    public List<ProductDTO> getAllProductsWithSalesData() {
        return statisticsService.getAllProductsWithSalesData().stream().map(productMapper::mapToDTO).collect(Collectors.toList());
    }


    //	Ordering list of products by sales (parametrized request: ascending or descending)
    @GetMapping("/productss")
    public List<ProductDTO> getProductBySalesOrder(@RequestParam("orderby") String order) {
        if ("desc".equals(order)) {
            return statisticsService.getAllProductsWithSalesDataOrderBySales(
                    new Sort(Sort.Direction.DESC, "sales.unit"))
                    .stream().map(productMapper::mapToDTO).collect(Collectors.toList());
        } else if ("asc".equals(order)) {
            return statisticsService.getAllProductsWithSalesDataOrderBySales(
                    new Sort(Sort.Direction.ASC, "sales.unit"))
                    .stream().map(productMapper::mapToDTO).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException();
        }
    }


    //	Listing sellers with their sales data (sales unit and value)
    @GetMapping("/sellers")
    public List<Seller> getSellersWithSalesData() {
        return statisticsService.getAllSellersWithSalesData();
    }

    //	Listing top 5 sellers by total sales value
    @GetMapping("/whaaat")
    public void getTop5SellersByTotalSalesValue() {

    }

    //	Listing top 5 most viewed products
    public void getTop5ProductByQueryCount() {

    }


    //	Total sales per product category
    public void getSalesPerProductCategory() {

    }

}
