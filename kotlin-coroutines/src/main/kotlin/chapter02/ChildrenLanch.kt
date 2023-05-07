package chapter02

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {
            println("launch1: ${Thread.currentThread().name}")
            delay(1000L)
            println("3!")
        }
        launch {
            println("launch2: ${Thread.currentThread().name}")
            println("1!")
        }
        println("runBlokcing: ${Thread.currentThread().name}")
        delay(500L)
        println("2!")
    }
    // runblocking은 lauch가 다 끝나지 않으면 끝나지 않음
    println("4!")
}