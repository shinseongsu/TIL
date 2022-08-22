package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PerssimisticService {

    private final StockRepository stockRepository;

    public PerssimisticService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(Long id, Long quantity) {
        Stock stock = stockRepository.findByIdWithPesseimisticLock(id);

        stock.descrease(quantity);

        stockRepository.saveAndFlush(stock);
    }



}
