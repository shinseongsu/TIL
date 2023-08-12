package com.example.onlinestoreservice.controller;

import com.example.onlinestoreservice.controller.dto.UserSessionValidatorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserSessionController {

    @GetMapping("user-sessions/validate")
    public UserSessionValidatorResponse validate(@RequestParam("sessionId") UUID sessionId) {
        boolean isValid = UUID.fromString("ad8614c1-d3e9-4b62-971a-1e7b19345fcb").equals(sessionId);

        return UserSessionValidatorResponse.builder()
                .sessionId(sessionId)
                .valid(isValid)
                .build();
    }

}
