package com.imredobos.marketplace.controller;

import com.imredobos.marketplace.dto.RateDTO;
import com.imredobos.marketplace.entity.Rate;
import com.imredobos.marketplace.mapper.RateMapper;
import com.imredobos.marketplace.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rate")
public class RateController {

    private RateService rateService;

    private RateMapper rateMapper;

    @Autowired
    public RateController(RateService rateService, RateMapper rateMapper) {
        this.rateService = rateService;
        this.rateMapper = rateMapper;
    }

    @PostMapping("/seller/{sellerId}")
    public void rateSeller(@PathVariable Long sellerId, @RequestBody Rate rate) {
//        Rate rate = rateMapper.mapToEntity(rateD);
        rateService.saveRate(sellerId, rate);
    }
}
