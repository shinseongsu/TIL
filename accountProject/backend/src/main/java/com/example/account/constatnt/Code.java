package com.example.account.constatnt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum Code {
    SUCESS("0000", "성공하였습니다."),
    UNREGISTER_SUCCESS("0000", "해지 성공하였습니다.");

    private String code;
    private String message;
}
