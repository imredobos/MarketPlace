package com.imredobos.marketplace.marketplace.service;

import com.imredobos.marketplace.marketplace.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyService {

    @Autowired
    private ProductService productService;

    @Autowired
    private SaleService saleService;

    public void buyProduct(Long productId, Integer count) {
        Optional<Product> productOptional = productService.getProductById(productId);
        if (!productOptional.isPresent()) {
            throw new IllegalArgumentException();
        }

        Product product = productOptional.get();
        if (product.getStock() < count) {
            throw new IllegalArgumentException();
        }

        saleService.saveSale(product, count);
    }
}