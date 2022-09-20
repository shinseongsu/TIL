package com.example.sse.controller;

import com.example.sse.envent.SignUpEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/sse")
public class UserController {
    private static final Long SEE_SESSION_TIMEOUT = 30 * 60 * 1000L;

    private Set<SseEmitter> emitterSet = new CopyOnWriteArraySet<>();

    @GetMapping(value = "/notice", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter signUp(HttpServletRequest request) {
        SseEmitter emitter = new SseEmitter(SEE_SESSION_TIMEOUT);
        emitterSet.add(emitter);

        emitter.onTimeout(() -> emitterSet.remove(emitter));
        emitter.onCompletion(() -> emitterSet.remove(emitter));

        return emitter;
    }

    @Async
    @EventListener
    public void onSignupEvent(final SignUpEvent signupEvent) {

        List<SseEmitter> deadEmitters = new ArrayList<>();
        emitterSet.forEach(emitter -> {
            try {
                emitter.send(signupEvent, MediaType.APPLICATION_JSON);
            } catch (Exception e) {
                deadEmitters.add(emitter);
            }
        });
        emitterSet.removeAll(deadEmitters);
    }

}
