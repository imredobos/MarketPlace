package com.imredobos.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.imredobos.marketplace.entity.view.View;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @JsonView(View.Summary.class)
    private Long id;

    @Column(name = "name")
    @JsonView(View.Summary.class)
    private String name;

    @Column(name = "description")
    @JsonView(View.Summary.class)
    private String description;

    @Column(name = "price")
    @JsonView(View.Summary.class)
    private Integer price;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    @JsonView(View.Summary.class)
    private Category category;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seller_id", referencedColumnName = "seller_id", nullable = false)
    @JsonView(View.Summary.class)
    @JsonBackReference
    private Seller seller;

    @Column(name = "stock")
    @JsonView(View.Summary.class)
    private Integer stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonView(View.WithSales.class)
    @JsonManagedReference
    private Set<Sale> sales;

    @Column(name = "query_count")
    @JsonView(View.Summary.class)
    private int queryCount;

    public Product() {
    }

    public Product(String name, String description, Integer price, Category category, Seller seller, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.seller = seller;
        this.stock = stock;
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

    public void setId(Long id) {
        this.id = id;
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
