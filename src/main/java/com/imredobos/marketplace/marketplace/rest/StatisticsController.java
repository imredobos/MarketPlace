package com.imredobos.marketplace.marketplace.rest;

import com.imredobos.marketplace.marketplace.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    //  Listing products with sales data (sales unit and value)
    @GetMapping("/products")
    public void getAllProductsWithSalesData() {
        statisticsService.getAllProductsWithSalesData();
    }


    //	Ordering list of products by sales (parametrized request: ascending or descending)
    @GetMapping()
    public void getProductBySalesOrder(@RequestParam("orderby") String order) {
        if ("desc".equals(order)) {
            statisticsService.getAllProductsWithSalesDataOrderBySales(
                    new Sort(Sort.Direction.DESC, "sales.unit"));
        } else if ("asc".equals(order)) {
            statisticsService.getAllProductsWithSalesDataOrderBySales(
                    new Sort(Sort.Direction.ASC, "sales.unit"));
        }
    }


    //	Listing sellers with their sales data (sales unit and value)
    @GetMapping("/sellers")
    public void getSellersWithSalesData() {
        statisticsService.getAllSellersWithSalesData();
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
