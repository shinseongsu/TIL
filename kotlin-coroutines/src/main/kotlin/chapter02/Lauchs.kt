package chapter02

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        println("lauch1: ${Thread.currentThread().name}")
        delay(1000L) // suspension point
        println("3!")
    }

    launch {
        println("lauch2: ${Thread.currentThread().name}")
        println("1!")
    }
    println("runBlocking: ${Thread.currentThread().name}")
    delay(500L) // suspension point
    println("2!")
}