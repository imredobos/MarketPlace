package com.imredobos.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RateDTO {

    private Long id;
    private Integer rating;
    private String comment;
    private SellerDTO seller;

    public RateDTO() {
    }

    public RateDTO(Long id, Integer rating, String comment, SellerDTO seller) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public SellerDTO getSeller() {
        return seller;
    }

    public void setSeller(SellerDTO seller) {
        this.seller = seller;
    }
}
