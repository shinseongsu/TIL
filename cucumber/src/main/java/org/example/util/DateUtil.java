package org.example.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public final class DateUtil {

    public LocalDateTime now() {
        return LocalDateTime.now();
    }

}
