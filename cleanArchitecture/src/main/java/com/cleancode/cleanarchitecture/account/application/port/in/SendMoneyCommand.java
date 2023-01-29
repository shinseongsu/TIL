package com.cleancode.cleanarchitecture.account.application.port.in;

import com.cleancode.cleanarchitecture.account.domain.Account.AccountId;
import com.cleancode.cleanarchitecture.account.domain.Money;
import com.cleancode.cleanarchitecture.common.SelfValidating;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

    private final AccountId sourceAccountId;
    private final AccountId targetAccountId;
    private final Money money;

    public SendMoneyCommand(
            @NotNull AccountId sourceAccountId,
            @NotNull AccountId targetAccountId,
            @NotNull Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        this.valiedateSelf();
    }
}
