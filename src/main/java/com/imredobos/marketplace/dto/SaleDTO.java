package com.imredobos.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDateTime;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SaleDTO {

    private Long id;
    private ProductDTO product;
    private Integer unit;
    private Integer value;
    private LocalDateTime date;

    public SaleDTO() {
    }

    public SaleDTO(Long id, ProductDTO product, Integer unit, Integer value, LocalDateTime date) {
        this.id = id;
        this.product = product;
        this.unit = unit;
        this.value = value;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
