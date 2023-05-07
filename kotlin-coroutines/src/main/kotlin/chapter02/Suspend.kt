package chapter02

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun doThread() {
    println("launch1: ${Thread.currentThread().name}")
    delay(1000L)
    println("3!")
}

suspend fun doOne() {
    println("launch1: ${Thread.currentThread().name}")
    println("1!")
}

suspend fun doTwo() {
    println("runBlocking: ${Thread.currentThread().name}")
    delay(500L)
    println("2!")
}

fun main() = runBlocking<Unit> {
    launch {
        doThread()
    }
    launch {
        doOne()
    }
    doTwo()
}