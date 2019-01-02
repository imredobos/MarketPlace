package com.imredobos.marketplace.service;

import com.imredobos.marketplace.entity.Product;

public interface SaleService {
    void saveSale(Product product, Integer unit);
}
