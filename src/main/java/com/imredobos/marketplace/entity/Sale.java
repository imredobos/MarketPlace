package com.imredobos.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.imredobos.marketplace.entity.view.View;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    @JsonView(View.Summary.class)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    @JsonBackReference
    @JsonView(View.Summary.class)
    private Product product;

    @Column(name = "unit")
    @JsonView(View.Summary.class)
    private Integer unit;

    @Column(name = "value")
    @JsonView(View.Summary.class)
    private Integer value;

    @CreationTimestamp
    @Column(name = "create_date")
    @JsonView(View.Summary.class)
    private LocalDateTime date;

    public Sale() {
        this.date = LocalDateTime.now();
    }

    public Sale(Product product, Integer unit, Integer value) {
        this.product = product;
        this.unit = unit;
        this.value = value;
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getUnit() {
        return unit;
    }

    public Integer getValue() {
        return value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", product=" + product +
                ", unit=" + unit +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
