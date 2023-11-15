package org.course.challenge06

import io.kotest.matchers.string.shouldMatch
import io.kotest.matchers.*
import io.kotest.core.spec.style.WordSpec

class FunctionsExerciseTest: WordSpec() {
    init {

        "FunctionsExercise01" should {
            "higher order function that does file resource handling while offering the content of the file as String" {
                //TODO: function to make test pass
                FunctionsExercise01.doWithText(/*{content -> content.reversed()}*/) shouldBe FunctionsExercise01.reverseText()
                FunctionsExercise01.doWithText(/*{content -> content.uppercase()}*/) shouldBe FunctionsExercise01.upperCaseText()
            }
        }
        "FunctionsExercise02" should {
            "measure execution time" {
                fun block():Int {
                    Thread.sleep(100)
                    return 4
                }
                //TODO: uncomment next lines to make test pass
                //4 shouldBe FunctionsExercise02.measure{block()}
                FunctionsExercise02.printed.shouldMatch("""The execution took: ([1-9][0-9][0-9]) ms""")
            }
        }
    }
}