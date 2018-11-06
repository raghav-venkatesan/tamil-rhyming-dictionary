package ca.havensoft.tamilrhymingdictionary.repository

import javax.inject.Singleton

typealias WordsReceived = (List<String>) -> Unit

@Singleton
data class WordRepository(private val service: WordListService) {

    fun matchingWordList(wordToBeMatched: String, wordsReceived: WordsReceived) {
        wordsReceived.invoke(service.matchingWordList(wordToBeMatched))
    }

}