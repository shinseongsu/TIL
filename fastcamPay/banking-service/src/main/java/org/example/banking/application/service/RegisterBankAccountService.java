package org.example.banking.application.service;

import lombok.RequiredArgsConstructor;
import org.example.banking.adapter.out.extenal.bank.BankAccount;
import org.example.banking.adapter.out.extenal.bank.GetBankAccountRequest;
import org.example.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import org.example.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import org.example.banking.application.port.in.RegisterBankAccountCommand;
import org.example.banking.application.port.in.RegisterBankAccountUseCase;
import org.example.banking.application.port.out.RegisterBankAccountPort;
import org.example.banking.application.port.out.RequestBankAccountInfoPort;
import org.example.banking.domain.RegisteredBankAccount;
import org.example.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RegisteredBankAccountMapper mapper;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisteredBankAccount registerMembership(RegisterBankAccountCommand command) {

        BankAccount bankAccountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(
                command.getBankName(), command.getBankAccountNumber()
        ));
        boolean accountInfoValid = bankAccountInfo.isValid();

        if(accountInfoValid) {
            RegisteredBankAccountJpaEntity registedBankAccount = registerBankAccountPort.createRegistedBankAccount(
                    new RegisteredBankAccount.MembershipId(command.getMembershipId() + ""),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
            );

            return mapper.mapToDomainEntity(registedBankAccount);
        } else {
            return null;
        }
    }
}
