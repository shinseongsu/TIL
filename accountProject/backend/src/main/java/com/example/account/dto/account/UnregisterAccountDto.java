package com.example.account.dto.account;

import com.example.account.constatnt.Code;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UnregisterAccountDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Request {
        private String accountNumber;
    }

    @Getter
    @Setter
    @Builder
    public static class Response {
        private String code;
        private String meessage;

        public static Response success() {
            return Response.builder()
                    .code(Code.UNREGISTER_SUCCESS.getCode())
                    .meessage(Code.UNREGISTER_SUCCESS.getMessage())
                    .build();
        }
    }

}
