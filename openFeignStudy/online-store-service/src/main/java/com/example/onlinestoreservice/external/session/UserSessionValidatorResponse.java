package com.example.onlinestoreservice.external.session;

import lombok.Data;

@Data
public class UserSessionValidatorResponse {
    private boolean valid;
    private String sessionId;
}
