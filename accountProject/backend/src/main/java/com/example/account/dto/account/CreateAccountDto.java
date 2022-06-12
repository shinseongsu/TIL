package com.example.account.dto.account;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CreateAccountDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Request {
        private String name;
        private String birthDay;
        private String phoneNumber;
    }

    @Getter
    @Builder
    public static class Response {
        private String code;
        private String message;
        private String accountNumber;
    }
}
