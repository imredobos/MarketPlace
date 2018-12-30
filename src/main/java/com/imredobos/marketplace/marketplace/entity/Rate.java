package com.imredobos.marketplace.marketplace.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rates")
public class Rate {

    @Id
    @GeneratedValue
    @Column(name = "rate_id")
    private Long id;

    @Min(1)
    @Max(5)
    @NotNull
    @Column(name = "rating")
    private Integer rating;

    private String comment;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "seller_id", referencedColumnName = "seller_id", nullable = false)
    private Seller seller;

    public Rate() {
    }

    public Rate(@Min(1) @Max(5) @NotNull Integer rating, @Length(max = 100) String comment, Seller seller) {
        this.rating = rating;
        this.comment = comment;
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public Integer getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id=" + id +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", seller=" + seller +
                '}';
    }
}
