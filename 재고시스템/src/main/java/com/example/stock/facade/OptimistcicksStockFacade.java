package com.example.stock.facade;

import com.example.stock.service.OptimisticService;
import org.springframework.stereotype.Service;

@Service
public class OptimistcicksStockFacade {

    private OptimisticService optimisticService;

    public OptimistcicksStockFacade(OptimisticService optimisticService) {
        this.optimisticService = optimisticService;
    }

    public void decrease(Long id, Long quantity) throws InterruptedException {
        while(true) {
            try {
                optimisticService.decrease(id, quantity);

                break;
            } catch (Exception e) {
                Thread.sleep(50);
            }
        }
    }
}
