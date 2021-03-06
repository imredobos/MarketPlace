package com.imredobos.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.imredobos.marketplace.entity.view.View;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    @JsonView(View.Summary.class)
    private Long id;

    @Column(name = "first_name")
    @JsonView(View.Summary.class)
    private String firstName;

    @Column(name = "last_name")
    @JsonView(View.Summary.class)
    private String lastName;

    @Column(name = "email")
    @JsonView(View.Summary.class)
    private String email;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonView(View.WithProduct.class)
    private Set<Product> products;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonView(View.WithRates.class)
    private Set<Rate> rates;

    public Seller() {
    }

    public Seller(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Set<Rate> getRates() {
        return rates;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setRates(Set<Rate> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
