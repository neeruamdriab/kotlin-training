package org.course.challenge02


import io.kotest.matchers.*
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.booleans.shouldBeTrue

class OOExercise02Test : WordSpec() {
    init {
        "An Euro" should {
            "be a data class" {
//                TODO("Uncomment and fix me")
              Euro::class.isData.shouldBeTrue()
            }
            "be a subclass of Currency" {
//                TODO("Uncomment and fix me")
            val e: Currency = Euro(2, 5)
            e.symbol shouldBe Symbol.EUR
            }
            "have correct toString representation" {
//                TODO("Uncomment and fix me")
            val e = Euro(2, 5)
            e.toString() shouldBe "€: 2.05"
            val e2 = Euro(2)
            e2.toString() shouldBe "€: 2.--"
            }
        }
    }
}
