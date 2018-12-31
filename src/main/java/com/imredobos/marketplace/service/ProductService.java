package com.imredobos.marketplace.service;

import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.repository.ProductRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

@Component
public class ProductService {

    private ProductRepository productRepository;

    private SellerService sellerService;

    @Autowired
    public ProductService(ProductRepository productRepository, SellerService sellerService) {
        this.productRepository = productRepository;
        this.sellerService = sellerService;
    }

    public Optional<Product> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            int queryCount = product.get().getQueryCount();
            product.get().setQueryCount(++queryCount);
        }
        return product;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsBySeller(Long sellerId) {
        return productRepository.findAllProductsBySellerId(sellerId);
    }

    public Product saveProduct(Product product, Long sellerId) {
        Optional<Seller> seller = sellerService.getSellerById(sellerId);
        if (seller.isPresent()) {
            product.setSeller(seller.get());
            return productRepository.save(product);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Product updateProduct(Long productId, Product newProduct) {
        Optional<Product> productOptional = getProductById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setCategory(newProduct.getCategory());
            product.setDescription(newProduct.getDescription());
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
            product.setSeller(newProduct.getSeller());
            product.setStock(newProduct.getStock());
            return productRepository.save(product);
        } else  {
            throw new IllegalArgumentException();
        }
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
