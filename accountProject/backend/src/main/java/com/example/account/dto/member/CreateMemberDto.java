package com.example.account.dto.member;

import lombok.*;

public class CreateMemberDto {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Request {
        private String name;
        private String phoneNumber;
        private String birthDay;
    }

    @Getter
    @Setter
    @Builder
    public static class Response {
        private String code;
        private String message;
        private String accountNumber;
    }

}
