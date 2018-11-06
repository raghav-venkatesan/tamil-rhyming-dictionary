package ca.havensoft.tamilrhymingdictionary

import ca.havensoft.tamilrhymingdictionary.util.convertToTamilScript
import org.junit.Test

import org.junit.Assert.*

class UtilUnitTest {
    @Test
    fun conversion_isCorrect() {
        val tamilWord = convertToTamilScript("ondRaa")
        assertEquals(tamilWord, "ஒன்றா")
    }
}
