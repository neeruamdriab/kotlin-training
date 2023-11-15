package org.course.challenge03

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.*
/**
 * 1. Implement the divide method in Euro that has the following signature:
 * - fun div(divider:Int):Euro
 * - If the divider is <=0 throw an IllegalArgumentException

 *  2. Write a Kotest covering the following testcases:
 * - Happy flow (divider is > 0)
 * - Alternative flow (divider is <= 0)
 */

class KotestSampleTest