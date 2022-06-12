package com.example.account.dto.account;

import com.example.account.domain.account.AccountStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountResponseDto {
    private String accountNumber;
    private Long balance;
    private AccountStatus accountStatus;

    @Builder
    public AccountResponseDto(String accountNumber, Long balance, AccountStatus accountStatus) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountStatus = accountStatus;
    }

}
