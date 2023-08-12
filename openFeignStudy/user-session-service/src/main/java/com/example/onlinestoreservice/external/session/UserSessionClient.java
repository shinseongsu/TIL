package com.example.onlinestoreservice.external.session;

import com.example.onlinestoreservice.controller.dto.UserSessionValidatorResponse;

public interface UserSessionClient {
    UserSessionValidatorResponse validateSession(String uuid);
}
