package com.example.onlinestoreservice.external.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateSessionRequest {
    private String sessionId;
}
