package com.cleancode.cleanarchitecture.account.adapter.out.persistence;

import com.cleancode.cleanarchitecture.account.application.port.out.LoadAccountPort;
import com.cleancode.cleanarchitecture.account.application.port.out.UpdateAccountStatePort;
import com.cleancode.cleanarchitecture.account.domain.Account;
import com.cleancode.cleanarchitecture.account.domain.Activity;
import com.cleancode.cleanarchitecture.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {

    private final SpringDataAccountRepository accountRepository;
    private final ActivityRepository activityRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account loadAccount(Account.AccountId accountId, LocalDateTime baselineDate) {

        AccountJpaEntity account =
                accountRepository.findById(accountId.getValue())
                        .orElseThrow(EntityNotFoundException::new);

        List<ActivityJpaEntity> activities =
                activityRepository.findByOwnerSince(
                        accountId.getValue(),
                        baselineDate);

        Long withdrawalBalance = orZero(activityRepository
                .getWithdrawalBalanceUntil(
                        accountId.getValue(),
                        baselineDate));

        Long depositBalance = orZero(activityRepository
                .getDepositBalanceUntil(
                        accountId.getValue(),
                        baselineDate));

        return accountMapper.mapToDomainEntity(
                account,
                activities,
                withdrawalBalance,
                depositBalance);
    }

    private Long orZero(Long value){
        return value == null ? 0L : value;
    }

    @Override
    public void updateActivities(Account account) {
        for (Activity activity : account.getActivityWindow().getActivities()) {
            if (activity.getId() == null) {
                activityRepository.save(accountMapper.mapToJpaEntity(activity));
            }
        }
    }
}
