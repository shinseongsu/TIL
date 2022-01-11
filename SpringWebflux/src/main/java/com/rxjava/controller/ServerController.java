package com.rxjava.controller;

import com.rxjava.model.Dish;
import com.rxjava.service.KitchenService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ServerController {

    private final KitchenService kitchen;

    public ServerController(KitchenService kitchen) {
        this.kitchen = kitchen;
    }

    @GetMapping(value = "/getfirst", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Dish> getFirstDishes() {
        return this.kitchen.getDishes();
    }

}
