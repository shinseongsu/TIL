package com.cleancode.cleanarchitecture.global.configuration;

import com.cleancode.cleanarchitecture.account.application.service.MoneyTransferProperties;
import com.cleancode.cleanarchitecture.account.domain.Money;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuckPalConfiguration {

    @Value("${buckpal.transferThreshold}")
    private Long transferThreshold;

    @Bean
    public MoneyTransferProperties moneyTransferProperties() {
        return new MoneyTransferProperties(Money.of(this.transferThreshold));
    }

}
