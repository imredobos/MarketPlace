package com.imredobos.marketplace.repository;

import com.imredobos.marketplace.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "select p.category as category, sum(s.unit) as totalSales from sales s " +
            "join products p on p.product_id = s.sale_id group by p.category",
            nativeQuery = true)
    List<Map<String, Integer>> findTotalSalesPerProductCategory();
}
