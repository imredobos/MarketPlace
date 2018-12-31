package com.imredobos.marketplace.controller;

import com.imredobos.marketplace.dto.ProductDTO;
import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.mapper.ProductMapper;
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

    private ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, SellerService sellerService, ProductMapper productMapper) {
        this.productService = productService;
        this.sellerService = sellerService;
        this.productMapper = productMapper;
    }

    // Saving product into the database by seller (ID, name, description, price, category, seller, stock)
    @PostMapping("/seller/{sellerId}")
    public ResponseEntity saveProduct(@RequestBody ProductDTO productDTO, @PathVariable Long sellerId) {
        Product product = productMapper.mapToEntity(productDTO);
        productService.saveProduct(product, sellerId);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    // Listing products
    @GetMapping
    public List<Product> getAllProduct() {
        //TODO lekér mindent
        return productService.getAllProducts();
    }

    // Listing products by seller
    @GetMapping("/seller/{sellerId}")
    public List<Product> getAllProductBySeller(@PathVariable Long sellerId) {
        // TODO fos
        return productService.getAllProductsBySeller(sellerId);
    }

    // Deleting product by ID
    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    // Getting product by ID
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        //TODO fos mindent lekérdez
        Optional<Product> product = productService.getProductById(productId);
        if (!product.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.get());
    }

    // Modifying product data by ID
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProductById(@PathVariable Long productId, @RequestBody Product product) {
        //TODO seller_id mapping
        Product updateProduct = productService.updateProduct(productId, product);
        return ResponseEntity.ok(updateProduct);
    }

}
