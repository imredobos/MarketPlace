package com.imredobos.marketplace.repository;

import com.imredobos.marketplace.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.seller.id = :sellerId")
    List<Product> findAllProductsBySellerId(@Param("sellerId") Long sellerId);

    @Query("select p from Product p JOIN FETCH p.sales")
    List<Product> findAllProductsWithSales();

    @Query("select p from Product p LEFT JOIN FETCH p.sales s group by p order by s.unit asc NULLS FIRST")
    List<Product> findAllProductsWithSalesOrderBySalesAsc();

    @Query("select p from Product p LEFT JOIN FETCH p.sales s group by p order by s.unit desc NULLS LAST")
    List<Product> findAllProductsWithSalesOrderBySalesDesc();

    @Query("select p from Product p order by p.queryCount desc NULLS LAST")
    List<Product> findTop5ByQueryCount();
}
