package org.example.banking.application.port.out;

import org.example.banking.adapter.out.extenal.bank.BankAccount;
import org.example.banking.adapter.out.extenal.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {

    BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
