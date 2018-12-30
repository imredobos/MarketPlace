package com.imredobos.marketplace.marketplace.rest;

import com.imredobos.marketplace.marketplace.entity.Rate;
import com.imredobos.marketplace.marketplace.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rate")
public class RateController {

    @Autowired
    private RateService rateService;

    @PostMapping("/seller/{sellerId}")
    public void rateSeller(@PathVariable Long sellerId, @RequestBody Rate rate) {
        rateService.saveRate(sellerId, rate);
    }
}
