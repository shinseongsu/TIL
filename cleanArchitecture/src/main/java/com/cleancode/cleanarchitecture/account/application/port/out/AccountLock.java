package com.cleancode.cleanarchitecture.account.application.port.out;

import com.cleancode.cleanarchitecture.account.domain.Account;

public interface AccountLock {

    void lockAccount(Account.AccountId accountId);

    void releaseAccount(Account.AccountId accountId);
}
