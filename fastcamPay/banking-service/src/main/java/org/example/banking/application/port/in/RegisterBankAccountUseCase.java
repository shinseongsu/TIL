package org.example.banking.application.port.in;

import org.example.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {

    RegisteredBankAccount registerMembership(RegisterBankAccountCommand command);
}
