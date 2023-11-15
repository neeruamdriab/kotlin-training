package org.course.challenge05

import com.fasterxml.jackson.databind.ObjectMapper
import java.lang.IllegalArgumentException

/**
 * Open: GenericsExercise.kt and GenericsExerciseTest
 * Exercise 1:
 * In GenericsExercise familiarize yourself with the domain classes  @{link Animal},  @{link Dog},  @{link Printer},  @{link AnimalPrinter}.
 * Introduce generics in the Printer class so that test Exercise 1a in GenericsExerciseTest succeeds.
 *
 * Exercise 2:
 * The extension method fun <T> ObjectMapper.readFromJsonString(json:String, clazz:Class<T>) uses the parameter clazz to
 * deserialize a json string to a class. Rewrite this extension method by using a reified type, so that the clazz parameter can
 * be removed and the method can be called with a type instead: mapper.readFromJsonString<Dog>(json).
 * Uncomment test Exercise 5 in GenericsExerciseTest once you have provided the implementation.
 */


/*------------------
* Animal domain (Exercise 1)
* ------------------
*/
open class Animal(val name: String) {
    val type = this::class.java.simpleName
}

class Dog(name: String) : Animal(name) {
    fun bark() = println("$type with name $name says: bark")
}

abstract class Printer {
    abstract fun print(input: Any): Unit
}

class AnimalPrinter : Printer() {
    override fun print(animal: Any) = if (animal is Animal) println("The ${animal.type} is called ${animal.name}") else throw IllegalArgumentException("$animal is no animal!!!")
}

/*------------------
* Reification (Exercise 2)
* Use a reified type so that the clazz:Class<T> parameter can be omitted.
* ------------------
*/

fun <T> ObjectMapper.readFromJsonString(json:String, clazz:Class<T>) = this.readValue(json, clazz)