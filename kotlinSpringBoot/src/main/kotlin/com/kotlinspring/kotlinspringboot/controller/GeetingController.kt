package com.kotlinspring.kotlinspringboot.controller

import com.kotlinspring.kotlinspringboot.service.GreetingsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greeting")
class GeetingController(val greetingsService: GreetingsService) {

    @GetMapping("/{name}")
    fun retrieveGreeting(@PathVariable("name") name: String): String {
        // return "Hello $name"
        return greetingsService.retrieveGreeting(name);
    }

}