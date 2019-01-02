package com.imredobos.marketplace.controller;

import com.imredobos.marketplace.entity.Rate;
import com.imredobos.marketplace.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rate")
public class RateController {

    private RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping("/seller/{sellerId}")
    @ResponseStatus(HttpStatus.OK)
    public void rateSeller(@PathVariable Long sellerId, @RequestBody Rate rate) {
        rateService.saveRate(sellerId, rate);
    }
}
