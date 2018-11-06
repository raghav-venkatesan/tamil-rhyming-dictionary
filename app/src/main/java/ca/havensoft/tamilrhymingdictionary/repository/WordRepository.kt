package ca.havensoft.tamilrhymingdictionary.repository

import ca.havensoft.tamilrhymingdictionary.model.Word
import javax.inject.Singleton

typealias WordsReceived = (List<Word>) -> Unit

@Singleton
data class WordRepository(private val service: WordListService) {

    fun matchingWordList(wordToBeMatched: String, wordsReceived: WordsReceived) {
        wordsReceived.invoke(service.matchingWordList(wordToBeMatched))
    }

}