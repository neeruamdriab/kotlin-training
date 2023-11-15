package org.course

import java.time.LocalDateTime

fun main(args:Array<String>) {
    val today = LocalDateTime.now()
    println("Hello Kotlin! How are you today at $today? Args: ${args.joinToString()}")
}