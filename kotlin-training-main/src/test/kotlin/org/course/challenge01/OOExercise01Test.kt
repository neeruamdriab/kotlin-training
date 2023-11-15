package org.course.challenge01


import io.kotest.matchers.*
import io.kotest.core.spec.style.WordSpec

class OOExercise01Test : WordSpec() {
    init {
        "Creating an Euro" should {
            "be initialized correctly" {
                val e = Euro(1, 5)
                e.euro shouldBe 1
                e.cents shouldBe 5

            }
            "have correct default value for cents" {
                val e = Euro(2)
                e.euro shouldBe 2
                e.cents shouldBe 0
            }
            "convert amount correctly to cents" {
                val e = Euro(2, 45)
                e.inCents shouldBe 245
            }
            "be created by cents" {
                val e = Euro.fromCents(245)
                e.euro shouldBe 2
                e.cents shouldBe 45
            }
            "add another euro correctly" {
                val res = Euro(1, 50) + (Euro(2, 70))
                res.euro shouldBe 4
                res.cents shouldBe 20
            }
            "add another euro correctly met plus" {
                val res = Euro(1, 50).plus(Euro(2, 70))
                res.euro shouldBe 4
                res.cents shouldBe 20
            }
            "multiply correctly by a factor" {
                val res = Euro(1, 50).times(3)
                res.euro shouldBe 4
                res.cents shouldBe 50
            }
        }
    }
}
