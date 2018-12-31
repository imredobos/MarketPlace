package com.imredobos.marketplace.service;

import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    private SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public void deleteSellerById(Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }

    public Optional<Seller> getSellerById(Long sellerId) {
        return sellerRepository.findById(sellerId);
    }

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Seller updateSeller(Long sellerId, Seller newSeller) {
        Optional<Seller> sellerOptional = getSellerById(sellerId);
        if (sellerOptional.isPresent()) {
            Seller seller = sellerOptional.get();
            seller.setFirstName(newSeller.getFirstName());
            seller.setLastName(newSeller.getLastName());
            seller.setEmail(newSeller.getEmail());
            return saveSeller(seller);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
}
