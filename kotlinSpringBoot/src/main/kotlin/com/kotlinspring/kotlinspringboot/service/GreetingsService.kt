package com.kotlinspring.kotlinspringboot.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GreetingsService {

    @Value("\${message}")
    lateinit var meessage: String

    fun retrieveGreeting(name: String) = "$name, $meessage"

}