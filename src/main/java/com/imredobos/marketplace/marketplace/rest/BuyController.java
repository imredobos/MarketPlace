package com.imredobos.marketplace.marketplace.rest;

import com.imredobos.marketplace.marketplace.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    @PostMapping("/{productId}")
    public void buyProduct(@PathVariable Long productId, @RequestBody Integer count) {
        buyService.buyProduct(productId, count);
    }
}
