package com.cleancode.cleanarchitecture.account.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ActivityJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime timestamp;

    @Column
    private Long ownerAccountId;

    @Column
    private Long sourceAccountId;

    @Column
    private Long targetAccountId;

    @Column
    private Long amount;

    public ActivityJpaEntity(Long id, LocalDateTime timestamp, Long ownerAccountId, Long sourceAccountId, Long targetAccountId, Long amount) {
        this.id = id;
        this.timestamp = timestamp;
        this.ownerAccountId = ownerAccountId;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
    }
}
