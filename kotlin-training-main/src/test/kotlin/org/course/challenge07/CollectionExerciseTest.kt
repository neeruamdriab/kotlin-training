package org.course.challenge07

import io.kotest.matchers.*
import io.kotest.core.spec.style.WordSpec


class CollectionExerciseTest : WordSpec() {
    init {
        "CollectionExercise01" should {
            "group a list of adults by age group. Each group is sorted by name"  {
                val jack = Person(14, "Jack")
                val duke = Person(32, "Duke")
                val jeniffer = Person(34, "Jeniffer")
                val erik = Person(24, "Erik")
                val susy = Person(40, "Susy")
                val result = CollectionExercise01.groupAdultsPerAgeGroup(listOf(jack, duke, jeniffer, erik, susy))
                result shouldBe mapOf(20 to listOf(erik), 30 to listOf(duke, jeniffer), 40 to listOf(susy))
            }
        }

        "CollectionExercise02" should {
            "calculate the length of the longest word in a list of sentences" {
                val l1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque pharetra lorem ut sem feugiat tristique. "
                val l2 = "Etiam id magna ut libero ullamcorperano scelerisque. "
                val result = CollectionExercise02.calcLengthLongestWord(l1, l2)
                result shouldBe "ullamcorperano".length
            }
        }

        "CollectionExercise03" should {
            "use fold to implement higher order function: filter" {
                val input = listOf(1, 2, 3)
                CollectionExercise03.filterWithFold(input) shouldBe input.filter { it % 2 == 0 }
            }
            "use fold to implement higher order function: groupBy" {
                val input = listOf(1, 2, 3)
                CollectionExercise03.groupByWithFold(input) shouldBe input.groupBy { it % 2 == 0 }
            }
        }

        "CollectionExercise04" should {
            "calculate the sum of all words in a small list of sentences" {
                val result = CollectionExercise04.createListOfSentencesAndCalcTheSumOfAllWords(10)
                result shouldBe 110
            }
            "calculate the sum of all words in a large list of sentences" {
                val result = CollectionExercise04.createListOfSentencesAndCalcTheSumOfAllWords(5_000_000)
                result shouldBe 307539777
            }
        }

        "CollectionExercise05" should {
            "generate fibonacci sequence starting with 1" {
                val result = CollectionExercise05.fibonacci().take(8).toList()
                result shouldBe listOf(1,2,3,5,8,13,21,34)
            }
            "find the sum of the even-valued fibonacci terms (even numbers) for a given maximum" {
                val r1 = CollectionExercise05.eulerProblem2(100)
                r1 shouldBe listOf(2, 8, 34).sum()

                val r2 = CollectionExercise05.eulerProblem2(4_000_000)
                r2 shouldBe 4613732
            }
        }

    }
}


