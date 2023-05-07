package chapter01

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println(this)
    println(Thread.currentThread().name)
    println("Hello")
}