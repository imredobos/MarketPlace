package com.imredobos.marketplace.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.entity.view.View;
import com.imredobos.marketplace.service.ProductService;
import com.imredobos.marketplace.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @JsonView(View.Summary.class)
    @PostMapping("/seller/{sellerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody Product product, @PathVariable Long sellerId) {
        productService.saveProduct(product, sellerId);
    }

    // Listing products
    @JsonView(View.Summary.class)
    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    // Listing products by seller
    @GetMapping("/seller/{sellerId}")
    @JsonView(View.Summary.class)
    public List<Product> getAllProductBySeller(@PathVariable Long sellerId) {
        return productService.getAllProductsBySeller(sellerId);
    }

    // Deleting product by ID
    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    // Getting product by ID
    @GetMapping("/{productId}")
    @JsonView(View.Summary.class)
    public Product getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    // Modifying product data by ID
    @PutMapping("/{productId}")
    @JsonView(View.Summary.class)
    public Product updateProductById(@PathVariable Long productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }
}
