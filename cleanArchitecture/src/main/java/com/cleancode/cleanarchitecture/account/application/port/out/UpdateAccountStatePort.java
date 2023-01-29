package com.cleancode.cleanarchitecture.account.application.port.out;

import com.cleancode.cleanarchitecture.account.domain.Account;

public interface UpdateAccountStatePort {

    void updateActivities(Account account);
}
