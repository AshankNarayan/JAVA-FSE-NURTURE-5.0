package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.entity.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public List<Stock> getFBStocksInSeptember2019(Date start, Date end) {
        return stockRepository.findByCodeAndDateBetween("FB", start, end);
    }

    @Transactional
    public List<Stock> getGoogleStocksGreaterThan(BigDecimal price) {
        return stockRepository.findByCodeAndCloseGreaterThan("GOOGL", price);
    }

    @Transactional
    public List<Stock> getTop3HighestVolumeStocks() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional
    public List<Stock> getTop3LowestNetflixStocks() {
        return stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
    }
}
