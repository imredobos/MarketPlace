package com.imredobos.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name = "products")
public class Product {

    public static final String PRODUCT_ASD = "product.asd";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "seller_id", referencedColumnName = "seller_id")
    private Seller seller;

    @Column(name = "stock")
    private Integer stock;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Sale> sales;

    @Column(name = "query_count")
    private int queryCount;

    public Product() {
//        this.sales = new HashSet<>();
    }

    public Product(String name, String description, Integer price, Category category, Seller seller, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.seller = seller;
        this.stock = stock;
//        this.sales = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Seller getSeller() {
        return seller;
    }

    public Integer getStock() {
        return stock;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public int getQueryCount() {
        return queryCount;
    }

    public void setQueryCount(int queryCount) {
        this.queryCount = queryCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", seller=" + seller +
                ", stock=" + stock +
                ", queryCount=" + queryCount +
                '}';
    }
}
