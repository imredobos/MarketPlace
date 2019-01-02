package com.imredobos.marketplace.service.impl;

import com.imredobos.marketplace.entity.Rate;
import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.repository.RateRepository;
import com.imredobos.marketplace.service.RateService;
import com.imredobos.marketplace.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {

    private RateRepository rateRepository;

    private SellerService sellerService;

    @Autowired
    public RateServiceImpl(RateRepository rateRepository, SellerService sellerService) {
        this.rateRepository = rateRepository;
        this.sellerService = sellerService;
    }

    @Override
    public void saveRate(Long sellerId, Rate rate) {
        Seller seller = sellerService.getSellerById(sellerId);
        rate.setSeller(seller);
        rateRepository.save(rate);
    }
}
