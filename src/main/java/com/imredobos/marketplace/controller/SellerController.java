package com.imredobos.marketplace.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.entity.view.View;
import com.imredobos.marketplace.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    private SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    // Deleting seller by ID
    @DeleteMapping("/{sellerId}")
    @JsonView(View.Summary.class)
    public void deleteSellerById(@PathVariable Long sellerId) {
        sellerService.deleteSellerById(sellerId);
    }

    // Getting seller by ID
    @GetMapping("/{sellerId}")
    @JsonView(View.Summary.class)
    public Seller getSellerById(@PathVariable Long sellerId) {
        return sellerService.getSellerById(sellerId);
    }

    // Listing sellers
    @GetMapping
    @JsonView(View.Summary.class)
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    // Modifying seller data by ID
    @PutMapping("/{sellerId}")
    @JsonView(View.Summary.class)
    public Seller updateSellerById(@PathVariable Long sellerId, @RequestBody Seller seller) {
        return sellerService.updateSeller(sellerId, seller);
    }

    // Saving people into the database (ID, first name, last name, email...)
    @PostMapping
    @JsonView(View.Summary.class)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSeller(@RequestBody Seller seller) {
        sellerService.saveSeller(seller);
    }
}
