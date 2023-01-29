package com.cleancode.cleanarchitecture.account.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Activity {

    private ActivityId id;

    private final Account.AccountId ownerAccountId;

    private final Account.AccountId sourceAccountId;

    private final Account.AccountId targetAccountId;

    private final LocalDateTime timestamp;

    private final Money money;

    public Activity(
            @NotNull Account.AccountId ownerAccountId,
            @NotNull Account.AccountId sourceAccountId,
            @NotNull Account.AccountId targetAccountId,
            @NotNull LocalDateTime timestamp,
            @NotNull Money money) {
        this.id = null;
        this.ownerAccountId = ownerAccountId;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.timestamp = timestamp;
        this.money = money;
    }

    @Getter
    public static class ActivityId {
        private final Long value;

        public ActivityId(Long value) {
            this.value = value;
        }
    }

}
