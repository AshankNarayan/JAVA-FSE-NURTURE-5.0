package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // 1. Get stock details of a company (e.g. FB) in a date range (e.g. Sep 2019)
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    // 2. Get stock details of a company (e.g. GOOGL) where close price > value (e.g. 1250)
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal price);

    // 3. Find top 3 stocks by volume descending
    List<Stock> findTop3ByOrderByVolumeDesc();

    // 4. Find top 3 stocks of a company (e.g. NFLX) ordered by close price ascending (lowest close)
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
