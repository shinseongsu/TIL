package com.example.pricecomparreredis.service;

import java.util.Set;

public interface LowestPriceService {

    Set getZsetValue(String key);
}
