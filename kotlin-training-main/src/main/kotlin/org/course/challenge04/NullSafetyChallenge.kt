package org.course.challenge04

/**
 * Take a look at the *sql* file: {@link resources/challenge04.sql}.
 * Port the code of the plsql FUNCTION confirmationMessage method to Kotlin making use of Kotlin's null-safety features.
 * The domain classes are already ported to Kotlin. Take a look at them below.
 *
 * Note: Because plsql does not have built-in nullability, the plsql code is stuffed with null checks.
 * By using Kotlin's null-safety features you are able to rewrite this plsql code in Kotlin with a
 * *single if expression that checks for null.* How can you do that?
 * You completed this exercise when the corresponding unittest NullSafetyExerciseTest succeeds.
 */
object NullableTypesExercise {

    fun confirmationMessage(account: Account?, booking: Booking?):String? {
        TODO("implement from resources/challenge04.aql")
    }

    private fun createMessage(email: String, amount: String, hotel: String) =
        "Confirmation for: $email amount: $amount hotel: $hotel"

}


class Account(val username: String,
              val email: String? = null
)

class Booking(
        val amount: Long? = null,
        val destination: Destination? = null
)


class Destination(
        val airport: String,
        val hotel: Hotel? = null
)

class Hotel(
        val name: String,
        val address: String,
        val stars: String? = null)
