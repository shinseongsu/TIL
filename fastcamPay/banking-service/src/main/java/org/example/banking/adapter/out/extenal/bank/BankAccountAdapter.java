package org.example.banking.adapter.out.extenal.bank;

import lombok.RequiredArgsConstructor;
import org.example.banking.adapter.out.persistence.SpringDataRegisteredBankAccountRepository;
import org.example.banking.application.port.out.RequestBankAccountInfoPort;
import org.example.common.ExternalSystemAdapter;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    private final SpringDataRegisteredBankAccountRepository bankAccountRepository;

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {
        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }
}
