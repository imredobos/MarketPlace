package com.imredobos.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SellerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    //private Set<ProductDTO> products;
    //private Set<RateDTO> rates;

    public SellerDTO() {
//        this.products = new HashSet<>();
//        this.rates = new HashSet<>();
    }

    public SellerDTO(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
//        this.products = new HashSet<>();
//        this.rates = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Set<ProductDTO> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<ProductDTO> products) {
//        this.products = products;
//    }
//
//    public Set<RateDTO> getRates() {
//        return rates;
//    }
//
//    public void setRates(Set<RateDTO> rates) {
//        this.rates = rates;
//    }
}
