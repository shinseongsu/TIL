package com.example.mongodb.global.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomBean {

    @Value("${name}")
    private String name;

}
