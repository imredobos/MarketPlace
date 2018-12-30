package com.imredobos.marketplace.marketplace.repository;

import com.imredobos.marketplace.marketplace.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
}
