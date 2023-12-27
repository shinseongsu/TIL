package org.example.banking.adapter.out.persistence;

import org.example.banking.domain.RegisteredBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {

    public RegisteredBankAccount mapToDomainEntity(RegisteredBankAccountJpaEntity bankingAccountRegisterInfoJpaEntity) {
        return RegisteredBankAccount.generateRegisteredBankAccount(
                new RegisteredBankAccount.RegisteredBankAccountId(bankingAccountRegisterInfoJpaEntity.getRegisteredBankAccountId()+""),
                new RegisteredBankAccount.MembershipId(bankingAccountRegisterInfoJpaEntity.getMembershipId()),
                new RegisteredBankAccount.BankName(bankingAccountRegisterInfoJpaEntity.getBankName()),
                new RegisteredBankAccount.BankAccountNumber(bankingAccountRegisterInfoJpaEntity.getBankAccountNumber()),
                new RegisteredBankAccount.LinkedStatusIsValid(bankingAccountRegisterInfoJpaEntity.isLinkedStatus())
        );
    }

}
