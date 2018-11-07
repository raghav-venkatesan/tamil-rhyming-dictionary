package ca.havensoft.tamilrhymingdictionary.model

import ca.havensoft.tamilrhymingdictionary.util.convertToTamilScript

data class Word(val latinScript: String) {

    val tamilScript = convertToTamilScript(latinScript)

}