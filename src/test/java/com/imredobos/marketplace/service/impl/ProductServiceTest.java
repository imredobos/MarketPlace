package com.imredobos.marketplace.service.impl;


import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.repository.ProductRepository;
import com.imredobos.marketplace.service.ProductService;
import com.imredobos.marketplace.service.SellerService;
import com.imredobos.marketplace.service.exception.ProductNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private SellerService sellerService;

    private Optional<Product> createTestProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setName("product_name");
        return Optional.ofNullable(product);
    }

    @Test
    public void testShouldGetProductWhenGetProductById() {
        when(productRepository.findById(1L)).thenReturn(createTestProduct());
        Product product = productService.getProductById(1L);
        assertEquals("product_name", product.getName());
    }

    @Test(expected = ProductNotFoundException.class)
    public void testShouldThrowExceptionWhneGetProductById() {
        when(productRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());
        productService.getProductById(1L);
    }
}
