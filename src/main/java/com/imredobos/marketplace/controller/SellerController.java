package com.imredobos.marketplace.controller;

import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    public void deleteSellerById(@PathVariable Long sellerId) {
        sellerService.deleteSellerById(sellerId);
    }

    // Getting seller by ID
    @GetMapping("/{sellerId}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long sellerId) {
        Optional<Seller> seller = sellerService.getSellerById(sellerId);
        if (!seller.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seller.get());
    }

    // Listing sellers
    @GetMapping("")
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
//                .map(sellerMapper::mapToDTO).collect(Collectors.toList());
    }

    // Modifying seller data by ID
    @PutMapping("/{sellerId}")
    public ResponseEntity<Seller> updateSellerById(@PathVariable Long sellerId, @RequestBody Seller seller) {
        Seller updateSeller = sellerService.updateSeller(sellerId, seller);
        return ResponseEntity.ok(updateSeller);
    }

    // Saving people into the database (ID, first name, last name, email...)
    @PostMapping
    public ResponseEntity saveSeller(@RequestBody Seller seller) {
        Seller savedSeller = sellerService.saveSeller(seller);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sellerId}").buildAndExpand(savedSeller.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
