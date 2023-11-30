package eu.azl.transitiedashboard.eu.azl.transitiedashboard

import kotlin.math.pow

/**
 * Maak CalculatorTest.kt in src/test/kotlin/eu/azl/transitiedashboard, en test all methods.
 *
 * 1. Test [add], [subtract], [multiply]
 * 2. Test [power] maar let op, power resulteert een floating point getal
 * 3. Test [factorial] maar let op, factorial kan je niet berekenen voor negatieve getallen.
 * 4. Test [divide] maar let op:
 *   - delen door 0 kan niet!
 *   - Getallen delen resulteert in floating point getallen,
 *     gebruik assertEquals(double1, double2, delta)
 */
class Calculator {
    fun add(
        num1: Int,
        num2: Int,
    ): Int = num1 + num2

    fun subtract(
        num1: Int,
        num2: Int,
    ): Int = num1 - num2

    fun multiply(
        num1: Int,
        num2: Int,
    ): Int = num1 * num2

    fun divide(
        num1: Int,
        num2: Int,
    ): Double =
        if (num2 != 0) {
            num1 / num2.toDouble()
        } else {
            throw IllegalArgumentException("Cannot divide by zero.")
        }

    fun power(
        base: Int,
        exponent: Int,
    ): Double = base.toDouble().pow(exponent)

    tailrec fun factorial(
        n: Int,
        acc: Long = 1,
    ): Long =
        when {
            n < 0 -> throw IllegalArgumentException("Cannot calculate factorial of a negative number.")
            n == 0 -> acc
            else -> factorial(n - 1, acc * n)
        }
}
