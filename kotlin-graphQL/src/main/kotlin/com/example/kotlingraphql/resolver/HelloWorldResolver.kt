package com.example.kotlingraphql.resolver

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.UUID

@Controller
class HelloWorldResolver {

    @QueryMapping
    fun helloworld(): String {
        return "Hello World!"
    }

    @QueryMapping
    fun greet(@Argument name: String): String {
        return "Hello $name"
    }

    @QueryMapping
    fun getRandomNumbers(): List<Int> {
        return listOf(1, 2,3 )
    }

    @QueryMapping
    fun getEvent(): Event {
        return Event(
            id = UUID.randomUUID(),
            eventType = "TESTING"
        )
    }
}

data class Event (
    val id: UUID,
    val eventType: String
)