package com.imredobos.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.HashSet;
import java.util.Set;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Integer price;
    private CategoryDTO category;
    private SellerDTO seller;
    private Integer stock;
    private Set<SaleDTO> sales;
    private int queryCount;

    public ProductDTO() {
        this.sales = new HashSet<>();
    }

    public ProductDTO(Long id, String name, String description, Integer price, CategoryDTO category, SellerDTO seller, Integer stock, int queryCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.seller = seller;
        this.stock = stock;
        this.sales = new HashSet<>();
        this.queryCount = queryCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public SellerDTO getSeller() {
        return seller;
    }

    public void setSeller(SellerDTO seller) {
        this.seller = seller;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Set<SaleDTO> getSales() {
        return sales;
    }

    public void setSales(Set<SaleDTO> sales) {
        this.sales = sales;
    }

    public int getQueryCount() {
        return queryCount;
    }

    public void setQueryCount(int queryCount) {
        this.queryCount = queryCount;
    }
}
