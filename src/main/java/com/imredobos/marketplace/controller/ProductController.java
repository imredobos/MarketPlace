package com.imredobos.marketplace.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.entity.Seller;
import com.imredobos.marketplace.entity.view.ProductView;
import com.imredobos.marketplace.service.ProductService;
import com.imredobos.marketplace.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    private SellerService sellerService;

    @Autowired
    public ProductController(ProductService productService, SellerService sellerService) {
        this.productService = productService;
        this.sellerService = sellerService;
    }

    // Saving product into the database by seller (ID, name, description, price, category, seller, stock)
    @JsonView(ProductView.Summary.class)
    @PostMapping("/seller/{sellerId}")
    public ResponseEntity saveProduct(@RequestBody Product product, @PathVariable Long sellerId) {
        try {
            productService.saveProduct(product, sellerId);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Listing products
    @JsonView(ProductView.Summary.class)
    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    // Listing products by seller
    @GetMapping("/seller/{sellerId}")
    @JsonView(ProductView.Summary.class)
    public ResponseEntity<List<Product>> getAllProductBySeller(@PathVariable Long sellerId) {
        Optional<Seller> seller = sellerService.getSellerById(sellerId);
        if (seller.isPresent()) {
            List<Product> products = productService.getAllProductsBySeller(sellerId);
            return ResponseEntity.ok(products);

        }
        return ResponseEntity.notFound().build();
    }

    // Deleting product by ID
    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProductById(@PathVariable Long productId) {
        Optional<Product> product = productService.getProductById(productId);
        if (product.isPresent()) {
            productService.deleteProduct(productId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Getting product by ID
    @GetMapping("/{productId}")
    @JsonView(ProductView.Summary.class)
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Optional<Product> product = productService.getProductById(productId);
        if (!product.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.get());
    }

    // Modifying product data by ID
    @PutMapping("/{productId}")
    @JsonView(ProductView.Summary.class)
    public ResponseEntity<Product> updateProductById(@PathVariable Long productId, @RequestBody Product product) {
        //TODO seller_id mapping
        Product updateProduct = productService.updateProduct(productId, product);
        return ResponseEntity.ok(updateProduct);
    }

}
