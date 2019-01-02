package com.imredobos.marketplace.service.impl;

import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.repository.ProductRepository;
import com.imredobos.marketplace.service.ProductService;
import com.imredobos.marketplace.service.SellerService;
import com.imredobos.marketplace.service.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private SellerService sellerService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, SellerService sellerService) {
        this.productRepository = productRepository;
        this.sellerService = sellerService;
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new ProductNotFoundException(productId);
        }
        Product product = optionalProduct.get();
        int queryCount = product.getQueryCount();
        product.setQueryCount(++queryCount);
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsBySeller(Long sellerId) {
        sellerService.getSellerById(sellerId);
        return productRepository.findAllProductsBySellerId(sellerId);
    }

    @Override
    public Product saveProduct(Product product, Long sellerId) {
        Seller seller = sellerService.getSellerById(sellerId);
        product.setSeller(seller);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product newProduct) {
        Product product = getProductById(productId);
        product.setCategory(newProduct.getCategory());
        product.setDescription(newProduct.getDescription());
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        product.setStock(newProduct.getStock());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (!product.isPresent()) {
            throw new ProductNotFoundException(productId);
        }
        productRepository.deleteById(productId);
    }
}
