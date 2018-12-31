package com.imredobos.marketplace.service;

import com.imredobos.marketplace.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseService {

    private ProductService productService;

    private SaleService saleService;

    @Autowired
    public PurchaseService(ProductService productService, SaleService saleService) {
        this.productService = productService;
        this.saleService = saleService;
    }

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