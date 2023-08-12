package com.example.onlinestoreservice.external.session;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface UserSessionClient {

    @RequestLine("GET /user-sessions/validate?sessionId={sessionId}")
    UserSessionValidatorResponse validateSession(@QueryMap Map<String, Object> queryMap);
}
