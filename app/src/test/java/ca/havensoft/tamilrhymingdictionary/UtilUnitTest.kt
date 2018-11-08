package ca.havensoft.tamilrhymingdictionary

import org.junit.Test

class UtilUnitTest {

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
