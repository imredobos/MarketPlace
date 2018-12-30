package com.imredobos.marketplace.marketplace.rest;

import com.imredobos.marketplace.marketplace.entity.Product;
import com.imredobos.marketplace.marketplace.entity.Seller;
import com.imredobos.marketplace.marketplace.service.ProductService;
import com.imredobos.marketplace.marketplace.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SellerService sellerService;

//    @Autowired
//    private ProductMapper productMapper;

    // Saving product into the database by seller (ID, name, description, price, category, seller, stock)
    @PostMapping("/seller/{sellerId}")
    public ResponseEntity saveProduct(@RequestBody Product product, @PathVariable Long sellerId) {
        Optional<Seller> seller = sellerService.getSellerById(sellerId);
        if (seller.isPresent()) {
            product.setSeller(seller.get());
            productService.saveProduct(product);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }

    // Listing products
    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    // Listing products by seller
    @GetMapping("/seller/{sellerId}")
    public List<Product> getAllProductBySeller(@PathVariable Long sellerId) {
        return productService.getAllProductBySeller(sellerId);
    }

    // Deleting product by ID
    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    // Getting product by ID
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Optional<Product> product = productService.getProductById(productId);
        if (!product.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.get());
    }

    // Modifying product data by ID
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProductById(@PathVariable Long productId, @RequestBody Product product) {
        Optional<Product> existingProduct = productService.getProductById(productId);
        if (!existingProduct.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Product updateProduct = productService.updateProduct(existingProduct.get(), product);
        return ResponseEntity.ok(updateProduct);
    }

}
