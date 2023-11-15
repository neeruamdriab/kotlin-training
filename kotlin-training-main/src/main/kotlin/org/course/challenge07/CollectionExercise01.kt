package org.course.challenge07

import java.util.ArrayList


class Person(val age: Int, val name: String)

object CollectionExercise01 {

    /**
     * Take a look at the SQL example in: src/main/resources/challenge07.sql.
     *
     * Using the query that calculates for each adult it’s age group as inspiration
     * (e.g. Duke is 32, so his age group is 30),
     * rewrite the algorithm in Kotlin using functional collections.
     *
     * Here are some hints:
     * 1. *filter* out all adults of the list of persons
     * 2. *sort* the list *by* name
     * 3. *group* each person *by* their age group, e.g. 30 -> List<duke, jeniffer>
     *    The age group you get as follows: age / 10 * 10
     */
    fun groupAdultsPerAgeGroup(persons: List<Person>): Map<Int, List<Person>> {
        TODO("fix me")
    }
}




