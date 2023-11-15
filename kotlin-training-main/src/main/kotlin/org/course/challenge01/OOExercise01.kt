package org.course.challenge01

/**
 * The goal of this exercise is to get familiar basic OO constructs in Kotlin
 *
 * Fix the code so that the unit test 'OOExercise01Test' passes.
 *
 * In order for the tests to pass you need to do the following:
 *
 * - Create a class Euro
 * - Provide it with two constructor parameters: euro:Int, cents:Int
 * - Provide the cents field with default value: 0
 * - Provide an immutable field named: inCents that converts euro + cents into cents.
 * - Create an object Euro with a factory method named: fromCents that creates an Euro based on cents.
 * - Create a method named: plus to the Euro class that adds another Euro
 * - Create a method named: times to the Euro class that multiplies an Euro with multiplier of type Int
 *
 */


    class Euro (val euro:Int, val cents:Int=0 ) {
        val inCents:Int = (euro * 100 + cents)

    operator fun plus(other:Euro): Euro {
        val totalCents:Int = cents + other.cents
        val euros:Int = totalCents / 100

        return  Euro(
            euro + other.euro + euros,
            totalCents % 100
        )
    }

    operator fun times(value:Int):Euro{
        val totalCents = cents * value
        val euros = totalCents / 100

        return Euro(
            (euro * value) + euros,
            totalCents % 100
        )
    }
    companion object{
        fun fromCents(cents:Int): Euro{
            val euro:Int = cents / 100
            val rest:Int = cents % 100
            return Euro(euro, rest)
        }
    }
}
