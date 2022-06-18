package com.kotlinspring.kotlinspringboot.util

import com.kotlinspring.kotlinspringboot.entity.Course

fun courseEntityList() = listOf(
    Course(null,
        "Build RestFul APis using SpringBoot and Kotlin", "Development"),
    Course(null,
            "Build Reactive Microservices using Spring WebFlux/SpringBoot", "Delvelopment"),
    Course(null,
        "Wiremock for Java Developers", "Development")

)