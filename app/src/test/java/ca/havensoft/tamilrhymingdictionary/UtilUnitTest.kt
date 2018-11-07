package ca.havensoft.tamilrhymingdictionary

import ca.havensoft.tamilrhymingdictionary.util.convertToTamilScript
import org.junit.Test

import org.junit.Assert.*

class UtilUnitTest {

    @Test
    fun tamil_conversion_isCorrect() {
        val tamilWord = convertToTamilScript("ondRaa")
        assertEquals(tamilWord, "ஒன்றா")
    }

    @Test
    fun regex_matching_isCorrect() {
        val word = "andRaadamkaaychchi"
        val regex = Regex("[^aeiou]*[aeiou]*")
        val matchedResults = regex.findAll(word)
        val result = StringBuilder()
        for (matchedText in matchedResults) {
            result.append("" + matchedText.value + " ")
        }

        println(result)
    }
}
