package com.example.pricecomparreredis.controller;

import com.example.pricecomparreredis.service.LowestPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class LowestPriceController {

    private final LowestPriceService lowestPriceService;

    @GetMapping("/getZSETValue")
    public Set getZestValue(String key) {
        return lowestPriceService.getZsetValue(key);
    }
}
