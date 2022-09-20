package com.example.sse.service;

import com.example.sse.entity.User;
import com.example.sse.envent.SignUpEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void signUp(final User user) {
        log.info(user.toString());
        applicationEventPublisher.publishEvent(new SignUpEvent(user));
    }

}
