package com.imredobos.marketplace.service;

import com.imredobos.marketplace.entity.Rate;
import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RateService {

    private RateRepository rateRepository;

    private SellerService sellerService;

    @Autowired
    public RateService(RateRepository rateRepository, SellerService sellerService) {
        this.rateRepository = rateRepository;
        this.sellerService = sellerService;
    }

    public Rate saveRate(Long sellerId, Rate rate) {
        Optional<Seller> seller = sellerService.getSellerById(sellerId);
        if (seller.isPresent()) {
            rate.setSeller(seller.get());
        } else {
            throw new IllegalArgumentException();
        }
        return rateRepository.save(rate);
    }
}
