package com.imredobos.marketplace.service.impl;

import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.repository.SellerRepository;
import com.imredobos.marketplace.service.SellerService;
import com.imredobos.marketplace.service.exception.SellerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    private SellerRepository sellerRepository;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void deleteSellerById(Long sellerId) {
        if (!sellerRepository.existsById(sellerId)) {
            throw new SellerNotFoundException(sellerId);
        }
        sellerRepository.deleteById(sellerId);
    }

    @Override
    public Seller getSellerById(Long sellerId) {
        Optional<Seller> seller = sellerRepository.findById(sellerId);
        if (!seller.isPresent()) {
            throw new SellerNotFoundException(sellerId);
        }
        return seller.get();
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller updateSeller(Long sellerId, Seller newSeller) {
        Seller seller = getSellerById(sellerId);
        seller.setFirstName(newSeller.getFirstName());
        seller.setLastName(newSeller.getLastName());
        seller.setEmail(newSeller.getEmail());
        return saveSeller(seller);

    }

    @Override
    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
}
