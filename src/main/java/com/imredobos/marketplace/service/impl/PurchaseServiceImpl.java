package com.imredobos.marketplace.service.impl;

import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.service.ProductService;
import com.imredobos.marketplace.service.PurchaseService;
import com.imredobos.marketplace.service.SaleService;
import com.imredobos.marketplace.service.exception.PurchaseNotPossibleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private ProductService productService;

    private SaleService saleService;

    @Autowired
    public PurchaseServiceImpl(ProductService productService, SaleService saleService) {
        this.productService = productService;
        this.saleService = saleService;
    }

    @Override
    public void buyProduct(Long productId, Integer count) {
        Product product = productService.getProductById(productId);

        if (product.getStock() < count) {
            throw new PurchaseNotPossibleException(productId);
        }

        saleService.saveSale(product, count);
    }
}