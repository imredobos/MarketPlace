package com.imredobos.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.imredobos.marketplace.entity.view.View;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rates")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rate_id")
    @JsonView(View.Summary.class)
    private Long id;

    @Min(1)
    @Max(5)
    @Column(name = "rating")
    @JsonView(View.Summary.class)
    private int rating;

    @JsonView(View.Summary.class)
    private String comment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seller_id", referencedColumnName = "seller_id", nullable = false)
    @JsonView(View.Summary.class)
    @JsonBackReference
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
