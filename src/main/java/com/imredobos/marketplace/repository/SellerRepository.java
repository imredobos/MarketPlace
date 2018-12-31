package com.imredobos.marketplace.repository;

import com.imredobos.marketplace.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Query(value = "select s from Seller s LEFT JOIN FETCH s.products p JOIN FETCH p.sales")
    List<Seller> findAllSellerWithSales();

    @Query(value = "select s from Seller s")
    List<Seller> findAllSellers();
}
