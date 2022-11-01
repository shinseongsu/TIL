package com.example.kotlinwebflux.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {

    val flow = simple()
    flow.collect{ value -> println(value) }

}

fun simple() : Flow<Int> = flow {
    println("Flow started")

    for (i in 1..3 ) {
        delay(100)
        emit(i)
    }
}