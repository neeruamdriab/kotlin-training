package org.course.challenge06

/**
 * Functions let you separate responsibilities, which allow you to maximally reuse code.
 *
 * Create a method measure that accepts any code blocks, executes it and prints the execution time.
 * E.g. 'The execution took <elapsed> ms'.
 * Use the logPerf method provided.
 * Provide a suitable implementation in order to make the corresponding unittest work.
 */
object FunctionsExercise02 {

    var printed = ""

    private fun logPerf(elapsed: Long) {
        printed = "The execution took: $elapsed ms"
    }

    fun <T> measure(/* provide correct method parameter */): T {
        TODO("fix me")
    }

}