package org.course.challenge07

import kotlin.math.max
import kotlin.math.min


object CollectionExercise04 {

    val sentenceGenerator = SentenceGenerator()

    /**
     * Use this method to generate a sentences
     */
    private fun createSentence() = sentenceGenerator.nextSentence()

    /**
     * Generate a list with as many sentences as defined in the input-parameter @param sentencesCount using
     * the utility @see createSentence() method. Calculate the sum of all words in the generated sentences.
     */
    fun createListOfSentencesAndCalcTheSumOfAllWords(sentencesCount: Int): Int {
        TODO("fix me")
    }
}

/**
 * Utility class that generates sentences in a deterministic way
 */
class SentenceGenerator(initialHeadIndex: Int = words.size / 2, initialTailIndex: Int = words.size / 2) {
    private var headIndex = initialHeadIndex
    private var tailIndex = initialTailIndex
    fun nextSentence(): String {
        if (headIndex++ >= words.size - 1) headIndex = 0
        if (tailIndex-- <= 0) tailIndex = 0
        return words.subList(min(headIndex, tailIndex), max(headIndex, tailIndex)).joinToString(" ")
    }

    companion object {
        val words = "Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean commodo ligula eget dolor Aenean massa Cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus Donec quam felis ultricies nec pellentesque eu pretium quis sem Nulla consequat massa quis enim Donec pede justo fringilla vel aliquet nec vulputate eget arcu In enim justo rhoncus ut imperdiet a venenatis vitae justo Nullam dictum felis eu pede mollis pretium Integer tincidunt Cras dapibus Vivamus elementum semper nisi Aenean vulputate eleifend tellus Aenean leo ligula porttitor eu consequat vitae eleifend ac enim Aliquam lorem ante dapibus in viverra quis feugiat a tellus Phasellus viverra nulla ut metus varius laoreet Quisque rutrum Aenean imperdiet Etiam ultricies nisi vel augue Curabitur ullamcorper ultricies nisi Nam eget dui".split(" ")
    }
}
