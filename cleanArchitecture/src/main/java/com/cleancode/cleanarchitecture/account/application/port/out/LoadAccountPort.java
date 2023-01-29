package com.cleancode.cleanarchitecture.account.application.port.out;

import com.cleancode.cleanarchitecture.account.domain.Account;

import java.time.LocalDateTime;

public interface LoadAccountPort {

    Account loadAccount(Account.AccountId accountId, LocalDateTime baselinseDate);
}
