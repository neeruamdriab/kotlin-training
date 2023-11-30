package eu.azl.transitiedashboard

import eu.azl.transitiedashboard.eu.azl.transitiedashboard.Calculator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun testAdd() {
//    Given
        val x = 1
        val y = 1
//    When
        val z = calculator.add(x, y)
//    Then
        assertEquals(2, z)
    }

    @Test
    fun testSubstract() {
//    Given
        val x = 5
        val y = 6
//    When
        val z = calculator.subtract(x, y)
//    Then
        assertEquals(-1, z)
    }

    @Test
    fun testMultiply() {
//    Given
        val x = 9
        val y = 5
//    When
        val z = calculator.multiply(x, y)
//    Then
        assertEquals(45, z)
    }

    @Test
    fun testPower() {
//    Given
        val x = -2
        val y = -4
//    When
        val z = calculator.power(x, y)
//    Then
        assertEquals(0.062, z, 0.001)
    }

    @Test
    fun testFactorial() {
//        Given
        val x = 3
//        When
        val z = calculator.factorial(x)
//        Then
        assertEquals(6, z)
    }

//    @Test
//    fun testFactorialException() {
// //    Given
//        val x = -2
// //    Then
//        assertThrows(IllegalArgumentException::class.java) {
//            calculator.factorial(x)
//        }
//    }

    @Test
    fun testDivide() {
//            Given
        val x = 10
        val y = 5
//            When
        val z = calculator.divide(x, y)
//            Then
        assertEquals(2.0, z, 0.001)
    }

    @Test
    fun testDivideException() {
//        Given
        val x = 2
        val y = 0
//        Then
        assertThrows(IllegalArgumentException::class.java) {
            calculator.divide(x, y)
        }
    }

    @Test
    fun testException() {
        assertThrows(IllegalArgumentException::class.java) {
//            throw RuntimeException("Boom!")
            calculator.divide(1, 0)
        }
    }

    @Test
    fun testFloatingPoints() {
//    assertEquals(1.0, 1.00, 0.001)
        assertEquals(
            1.0,
            2.0 / 2.0,
            0.001,
        )
    }
}
