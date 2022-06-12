package com.example.account.controller.member;

import com.example.account.constatnt.Code;
import com.example.account.domain.member.MemberStatus;
import com.example.account.domain.account.Account;
import com.example.account.domain.account.AccountStatus;
import com.example.account.domain.member.Member;
import com.example.account.dto.member.CreateMemberDto;
import com.example.account.service.member.MemberService;
import com.example.account.utils.AccountUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final AccountUtils accountUtils;

    @PostMapping(value = "/member")
    public ResponseEntity<?> createMembeer(@RequestBody @Valid CreateMemberDto.Request request) {

        Member member = Member.builder()
                .name(request.getName())
                .birthDay(request.getBirthDay())
                .phoneNumber(request.getPhoneNumber())
                .status(MemberStatus.NORMAL)
                .accounts(List.of(Account.builder()
                                    .accountNumber(accountUtils.create())
                                    .accountStatus(AccountStatus.IN_USE)
                                    .balance(1_000L)
                                    .build()))
                .build();

        memberService.createMember(member);

        return ResponseEntity.ok(CreateMemberDto.Response.builder()
                .code(Code.SUCESS.getCode())
                .message(Code.SUCESS.getMessage())
                .accountNumber(member.getAccounts().get(0).getAccountNumber())
                .build());
    }

}
