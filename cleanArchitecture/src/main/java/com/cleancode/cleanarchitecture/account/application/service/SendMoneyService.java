package com.cleancode.cleanarchitecture.account.application.service;

import com.cleancode.cleanarchitecture.account.application.port.in.SendMoneyCommand;
import com.cleancode.cleanarchitecture.account.application.port.in.SendMoneyUseCase;
import com.cleancode.cleanarchitecture.account.application.port.out.AccountLock;
import com.cleancode.cleanarchitecture.account.application.port.out.LoadAccountPort;
import com.cleancode.cleanarchitecture.account.application.port.out.UpdateAccountStatePort;
import com.cleancode.cleanarchitecture.account.domain.Account;
import com.cleancode.cleanarchitecture.common.UseCase;
import com.cleancode.cleanarchitecture.global.exception.ThresholdExceededException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@UseCase
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort;
    private final AccountLock accountLock;
    private final UpdateAccountStatePort updateAccountStatePort;
    private final MoneyTransferProperties moneyTransferProperties;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {

        checkThreshold(command);

        LocalDateTime baselineDate = LocalDateTime.now().minusDays(10);

        Account sourceAccount = loadAccountPort.loadAccount(
                command.getSourceAccountId(),
                baselineDate);

        Account targetAccount = loadAccountPort.loadAccount(
                command.getTargetAccountId(),
                baselineDate);

        Account.AccountId sourceAccountId = sourceAccount.getId()
                .orElseThrow(() -> new IllegalStateException("expected source account ID not to be empty"));
        Account.AccountId targetAccountId = targetAccount.getId()
                .orElseThrow(() -> new IllegalStateException("expected target account ID not to be empty"));

        accountLock.lockAccount(targetAccountId);
        if(!targetAccount.deposit(command.getMoney(), sourceAccountId)) {
            accountLock.releaseAccount(sourceAccountId);
            return false;
        }

        accountLock.lockAccount(targetAccountId);
        if (!targetAccount.deposit(command.getMoney(), sourceAccountId)) {
            accountLock.releaseAccount(sourceAccountId);
            accountLock.releaseAccount(targetAccountId);
            return false;
        }

        updateAccountStatePort.updateActivities(sourceAccount);
        updateAccountStatePort.updateActivities(targetAccount);

        accountLock.releaseAccount(sourceAccountId);
        accountLock.releaseAccount(targetAccountId);

        return true;
    }

    private void checkThreshold(SendMoneyCommand command) {
        if(command.getMoney().isGreaterThan(moneyTransferProperties.getMaximumTransferThreshold())){
            throw new ThresholdExceededException(moneyTransferProperties.getMaximumTransferThreshold(), command.getMoney());
        }
    }
}
