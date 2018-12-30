package com.imredobos.marketplace.marketplace.service;

import com.imredobos.marketplace.marketplace.entity.Seller;
import com.imredobos.marketplace.marketplace.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public void deleteSellerById(Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }

    public Optional<Seller> getSellerById(Long sellerId) {
        return sellerRepository.findById(sellerId);
    }

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Seller updateSeller(Seller oldSeller, Seller newSeller) {
        oldSeller.setFirstName(newSeller.getFirstName());
        oldSeller.setLastName(newSeller.getLastName());
        oldSeller.setEmail(newSeller.getEmail());
        return oldSeller;
    }

    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
}
