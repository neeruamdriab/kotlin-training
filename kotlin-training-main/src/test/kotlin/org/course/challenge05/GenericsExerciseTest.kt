package org.course.challenge05

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.*

class GenericsExerciseTest : WordSpec() {
    init {

        "GenericsExerciseTest" should {
            "Exercise 1: make Printer generic (Printer<T>) so that AnimalPrinter only accepts Animal objects" {
                val printer = AnimalPrinter()
                //should not compile
                printer.print("No animal")
                //should work
                printer.print(Dog("Fido"))

            }
            "Exercise 2: make the extension method ObjectMapper.readFromJsonString(...) use a reified type instead of a class argument to deserialize a json string" {
                val mapper = jacksonObjectMapper()
                val dogName = "Fido"
                val dogJson = """{"name":"$dogName"}"""
                TODO("uncomment next lines ")
//                val dog = mapper.readFromJsonString<Dog>(dogJson)
//                dog.name shouldBe dogName
            }
        }
    }
}
