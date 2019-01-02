package com.imredobos.marketplace.service;

import com.imredobos.marketplace.entity.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long productId);

    List<Product> getAllProducts();

    List<Product> getAllProductsBySeller(Long sellerId);

    Product saveProduct(Product product, Long sellerId);

    Product updateProduct(Long productId, Product newProduct);

    void deleteProduct(Long productId);
}
