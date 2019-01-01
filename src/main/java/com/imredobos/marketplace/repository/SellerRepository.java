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

    @Query("select s from Seller s LEFT JOIN FETCH s.rates r group by s order by avg(r.rating) desc NULLS LAST")
    List<Seller> findAllSellerOrderByAvgRatingDesc();

    @Query("select s from Seller s LEFT JOIN FETCH s.rates r group by s order by avg(r.rating) asc NULLS LAST")
    List<Seller> findAllSellerOrderByAvgRatingAsc();

    @Query("select s from Seller s " +
            "LEFT JOIN FETCH s.products p " +
            "LEFT JOIN FETCH p.sales sa" +
            " group by s order by sum(sa.value) desc NULLS LAST")
    List<Seller> findTop5SellersByTotalSalesValue();
}
