package chapter02

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        println("launch: ${Thread.currentThread().name}")
        println("World!")
    }
    println("runBlocking: ${Thread.currentThread().name}")
//    Thread.sleep(500)
    delay(500L)

    // Thread.sleep는 os에 쉬라고 얘기하지만, delpay는 양보하라는 뜻!

    println("Hello")
}