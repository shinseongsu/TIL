package com.cleancode.cleanarchitecture.account.application.service;

import com.cleancode.cleanarchitecture.account.domain.Money;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MoneyTransferProperties {

    private Money maximumTransferThreshold = Money.of(1_000_000L);

    public MoneyTransferProperties(Money maximumTransferThreshold) {
        this.maximumTransferThreshold = maximumTransferThreshold;
    }
}
