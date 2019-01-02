package com.imredobos.marketplace.service;

import com.imredobos.marketplace.entity.Seller;

import java.util.List;

public interface SellerService {
    void deleteSellerById(Long sellerId);

    Seller getSellerById(Long sellerId);

    List<Seller> getAllSellers();

    Seller updateSeller(Long sellerId, Seller newSeller);

    Seller saveSeller(Seller seller);
}
