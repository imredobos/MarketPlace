package com.imredobos.marketplace.marketplace.repository;

import com.imredobos.marketplace.marketplace.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllBySellerId(Long sellerId);

    @Query("select p from Product p LEFT JOIN FETCH p.sales")
    List<Product> findAllProductWithSales();

    @Query("select p from Product p LEFT JOIN FETCH p.sales")
    List<Product> findAllProductWithSalesOrderBySales(Sort sort);
}
