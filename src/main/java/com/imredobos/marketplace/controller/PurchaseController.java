package com.imredobos.marketplace.controller;

import com.imredobos.marketplace.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy")
public class PurchaseController {

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/{productId}/{count}")
    @ResponseStatus(HttpStatus.OK)
    public void buyProduct(@PathVariable Long productId, @PathVariable Integer count) {
        purchaseService.buyProduct(productId, count);
    }
}
