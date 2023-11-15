package org.course.challenge09

import io.kotest.matchers.collections.containExactlyInAnyOrder
import io.kotest.matchers.*
import io.kotest.core.spec.style.WordSpec
import org.course.challenge09.ControlFlowExercise01.matchOnInputType
import org.course.challenge09.ControlFlowExercise02.show
import org.course.challenge09.ControlFlowExercise03.diffResult
import kotlin.math.absoluteValue
import kotlin.random.Random

class ControlFlowExerciseTest : WordSpec() {
    init {
        "ControlFlowExercise01" should {
            "match a variety of branch conditions using when" {
                val random = Random(5)
                val randomString = System.currentTimeMillis().toString().map { it.toChar() }.joinToString("")
                val randomCharacter = random.nextInt('a'.code, 'z'.code).toChar()
                val randomPositiveInt = random.nextInt(10, 100)
                val randomNegativeInt = random.nextInt(1, 100) * -1
                val matchUs = listOf(
                    "Kotlin" to "Literal Kotlin",
                    randomString to "A string with length ${randomString.length}",
                    randomPositiveInt to "A positive integer",
                    randomNegativeInt to "A negative integer",
                    randomCharacter to "A character in alphabet: $randomCharacter",
                    (1..random.nextInt(10, 50).absoluteValue).toList() to "List with more than 10 element",
                    (1..random.nextInt(2, 9).absoluteValue).toList() to "List with less than 10 element",
                    emptyList<Any>() to "empty List",
                    (null as Long?) to "nullable value",
                    {} to "The default")

                matchUs.forEach { (param, expected) -> matchOnInputType(param) shouldBe expected }
            }
        }
    }
}
