package com.cleancode.cleanarchitecture.account.adapter.in.web;

import com.cleancode.cleanarchitecture.account.application.port.in.SendMoneyCommand;
import com.cleancode.cleanarchitecture.account.application.port.in.SendMoneyUseCase;
import com.cleancode.cleanarchitecture.account.domain.Account;
import com.cleancode.cleanarchitecture.account.domain.Money;
import com.cleancode.cleanarchitecture.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class SendMoneyController {

    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping(path = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    public void sendMoney(@PathVariable("sourceAccountId") Long sourceAccountId,
                          @PathVariable("targetAccountId") Long targetAccountId,
                          @PathVariable("amount") Long amount) {

        SendMoneyCommand command = new SendMoneyCommand(
                new Account.AccountId(sourceAccountId),
                new Account.AccountId(targetAccountId),
                Money.of(amount));

        sendMoneyUseCase.sendMoney(command);
    }
}
