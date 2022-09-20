package com.example.sse.envent;

import com.example.sse.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpEvent {
    private User user;
}
