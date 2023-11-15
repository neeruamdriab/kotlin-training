package org.course.challenge02

/**
 * The goal of this exercise is to get familiar basic OO constructs in Kotlin
 *
 * Fix the code so that the unit test 'OOExercise02Test' passes.
 *
 * In order for the tests to pass you need to do the following:
 *
 * - Create an Enum Symbol with constants for EUR and USD and an immutable field: sign:String
 * - Create an abstract class Currency
 * - Provide it with one constructor parameter: symbol:Symbol
 * - Convert the Euro class into a data class
 * - Extend the given Euro class from Currency
 * - Override the toString method of Euro to represent the following String:
 *   -> symbol.sign + ': ' + euro + '.' + cents.  E.g: € 200.05
 *   To format the cents use: String.format("%02d", cents)
 * - In case the cents are 0 use this representation:
 *   -> symbol.sign + ': ' + euro + '.--. E.g.: € 200.--
 */
enum class Symbol( val sign : String){
    EUR("€"),
    USD("$"),
}
abstract class Currency(val symbol:Symbol)

data class Euro(val euro: Int, val cents: Int = 0) : Currency(Symbol.EUR){
    val inCents: Int = euro * 100 + cents

    fun plus(other: Euro): Euro = fromCents(inCents + other.inCents)

    fun times(n: Int): Euro = fromCents(n * inCents)

    companion object {
        fun fromCents(cents: Int) = Euro(cents / 100, cents % 100)
    }

    override fun toString(): String {
        val sign: String = symbol.sign
        val cents: String = if (cents == 0) "--" else String.format("%02d", cents)


        return "$sign: $euro.$cents"
    }

}


fun main() {
    val e = Euro(2, 50)
//    val e = "test"
    println(e)
}