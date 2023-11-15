package org.course.challenge06

import java.util.*

/**
 * Higher order functions allow you to build abstractions containing a generic control
 * structure and a function with which the result(s) of the generic control structure can
 * be used in different ways.
 *
 * Take a look at the predefined methods {@link reverseText()} and {@link upperCaseTest()}.
 * Both methods contain a lot of duplication which we want to remove.
 *
 * Implement the {@link doWithText()} method as a higher order function
 * that takes care of the resource handling of the File and offers a function argument
 * that allows to deal with the content of the File, which is a String, directly.
 */
object FunctionsExercise01 {

    fun doWithText( /* provide correct function signature */): String {
        TODO("fix me")
    }

    fun reverseText(): String {
        val scanner = Scanner(this::class.java.getResourceAsStream("/text.txt"))
        try {
            scanner.useDelimiter("\\Z");
            val content = scanner.next()
            return content.reversed()
        } finally {
            scanner.close()
        }
    }

    fun upperCaseText(): String {
        val scanner = Scanner(this::class.java.getResourceAsStream("/text.txt"))
        try {
            scanner.useDelimiter("\\Z");
            val content = scanner.next()
            return content.uppercase()
        } finally {
            scanner.close()
        }
    }

}




