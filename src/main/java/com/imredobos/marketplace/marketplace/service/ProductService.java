package com.imredobos.marketplace.marketplace.service;

import com.imredobos.marketplace.marketplace.entity.Product;
import com.imredobos.marketplace.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            // TODO multithreaded increment
        }
        return product;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductBySeller(Long sellerId) {
        return productRepository.findAllBySellerId(sellerId);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product existing, Product newProduct) {
        existing.setCategory(newProduct.getCategory());
        existing.setDescription(newProduct.getDescription());
        existing.setName(newProduct.getName());
        existing.setPrice(newProduct.getPrice());
        existing.setSeller(newProduct.getSeller());
        existing.setStock(newProduct.getStock());
        return existing;
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
