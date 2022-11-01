package com.example.kotlinwebflux.coroutines

import kotlinx.coroutines.runBlocking

// -Dkotlinx.coroutines.debug

fun main() {

    runBlocking {
        println("Hello")
        println(Thread.currentThread().name)
    }

    println("World")
    println(Thread.currentThread().name)

}