package ca.havensoft.tamilrhymingdictionary.model

import ca.havensoft.tamilrhymingdictionary.util.convertToTamilScript

data class Word(val englishTransliteration: String) {

    val tamilScript = convertToTamilScript(englishTransliteration)

}