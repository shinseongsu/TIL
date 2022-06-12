package com.example.account.domain.account;

import com.example.account.domain.base.BaseEntity;
import com.example.account.domain.member.Member;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    private Long balance;

    @Column(name = "member_id")
    private Long memberId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", updatable = false, insertable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    public void unregister() {
        this.accountStatus = AccountStatus.UNREGISTERED;
    }

}
