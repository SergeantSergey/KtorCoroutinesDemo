package com.example

import kotlinx.coroutines.*
import kotlin.random.Random

fun main(array: Array<String>): Unit = runBlocking {

    withContext(Dispatchers.IO) {
        repeat(100_000) {
            launch {
                firstCoroutine(it)
            }
        }
        println("Done with the context")
    }
    println("End of main function")
}

suspend fun firstCoroutine(id: Int) {
    delay(Random.nextLong() % 2000)
    println("first $id")
}