package com.example.account.domain.transaction;

import com.example.account.domain.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Transaction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long amount;

    private Long vat;

    private Long supplyAmount;

    private String accountNumber;

    private String orderName;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private LocalDateTime approvedAt;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @Builder
    public Transaction(Long id, Long amount, Long vat, Long supplyAmount, String accountNumber,
                       String orderName, Currency currency, LocalDateTime approvedAt, AccountStatus accountStatus) {
        this.id = id;
        this.amount = amount;
        this.vat = vat;
        this.supplyAmount = supplyAmount;
        this.accountNumber = accountNumber;
        this.orderName = orderName;
        this.currency = currency;
        this.approvedAt = approvedAt;
        this.accountStatus = accountStatus;
    }

}
