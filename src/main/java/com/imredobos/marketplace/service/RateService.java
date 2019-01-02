package com.imredobos.marketplace.service;

import com.imredobos.marketplace.entity.Rate;

public interface RateService {
    void saveRate(Long sellerId, Rate rate);
}
