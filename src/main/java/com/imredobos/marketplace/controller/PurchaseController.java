package com.imredobos.marketplace.controller;

import com.imredobos.marketplace.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy")
public class PurchaseController {

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("/{productId}/{count}")
    public void buyProduct(@PathVariable Long productId, @PathVariable Integer count) {
        purchaseService.buyProduct(productId, count);
    }
}
