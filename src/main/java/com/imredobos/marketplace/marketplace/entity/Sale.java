package com.imredobos.marketplace.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Sale {

    @Id
    @GeneratedValue
    @Column(name = "sale_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Product product;

    @Column(name = "unit")
    private Integer unit;

    @Column(name = "value")
    private Integer value;

    @CreationTimestamp
    @Column(name = "create_date")
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
