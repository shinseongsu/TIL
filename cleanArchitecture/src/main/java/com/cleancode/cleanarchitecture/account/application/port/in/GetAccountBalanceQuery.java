package com.cleancode.cleanarchitecture.account.application.port.in;

import com.cleancode.cleanarchitecture.account.domain.Account;
import com.cleancode.cleanarchitecture.account.domain.Money;

public interface GetAccountBalanceQuery {

    Money getAccountBalance(Account.AccountId accountId);
}
