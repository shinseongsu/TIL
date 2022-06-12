package com.example.account.controller.account;

import com.example.account.constatnt.Code;
import com.example.account.dto.account.CreateAccountDto;
import com.example.account.dto.account.UnregisterAccountDto;
import com.example.account.service.account.AccountService;
import com.example.account.service.RedisTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final RedisTestService redisTestService;

    @GetMapping("/get-lock")
    public String getLock() {
        return redisTestService.getLock();
    }

    @DeleteMapping("/account")
    public ResponseEntity<?> unregistered(@RequestBody UnregisterAccountDto.Request request) {
        accountService.unregister(request);
        return ResponseEntity.ok(UnregisterAccountDto.Response.success());
    }

    @PostMapping("/account")
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountDto.Request request) {
        String accountNumber = accountService.createAccount(request);

        return ResponseEntity.ok(CreateAccountDto.Response.builder()
                        .code(Code.SUCESS.getCode())
                        .message(Code.SUCESS.getMessage())
                        .accountNumber(accountNumber)
                        .build());
    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable(value = "accountNumber") String accountNumber) {
        return ResponseEntity.ok(accountService.getAccount(accountNumber));
    }

}
