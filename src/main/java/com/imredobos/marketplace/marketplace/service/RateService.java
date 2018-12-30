package com.imredobos.marketplace.marketplace.service;

import com.imredobos.marketplace.marketplace.entity.Rate;
import com.imredobos.marketplace.marketplace.entity.Seller;
import com.imredobos.marketplace.marketplace.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RateService {

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private SellerService sellerService;

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
