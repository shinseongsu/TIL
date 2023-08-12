package com.example.onlinestoreservice.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@Builder
public class UserSessionValidatorResponse {

    private boolean valid;
    private UUID sessionId;

}
