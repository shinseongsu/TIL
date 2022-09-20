package com.example.sse.scheduler;

import com.example.sse.entity.User;
import com.example.sse.service.UserService;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignUpScheduler {
    private final UserService userService;

    private Random random = new Random();

    @Scheduled(fixedDelay = 2000)
    public void signupTask() {
        userService.signUp(createTestUser());
    }

    private User createTestUser() {
        return new User("빨간색", random.nextInt(30));
    }

}
