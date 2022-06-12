package com.example.account.domain.member;

import com.example.account.domain.account.Account;
import com.example.account.domain.base.BaseEntity;
import com.example.account.exception.AccountException;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;

    private String birthDay;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private List<Account> accounts;

    @Builder
    public Member(Long id, String name, String phoneNumber, String birthDay, MemberStatus status, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.status = status;
        this.accounts = accounts;
    }

    public void isAccountCountTen() {
        if(accounts.size() > 10) {
            throw new AccountException("계좌는 10개까지 생성가능합니다.");
        }
    }

}
