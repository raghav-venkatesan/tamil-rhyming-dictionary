package ca.havensoft.tamilrhymingdictionary.repository

import ca.havensoft.tamilrhymingdictionary.application.MATCH_BEGINNING
import ca.havensoft.tamilrhymingdictionary.application.MATCH_END
import ca.havensoft.tamilrhymingdictionary.model.Word

class WordListService(private val dictionaryList: List<Array<String>>) {

    fun matchingWordList(word: String, matchCriteria: Int): List<Word> {
        val wordList = ArrayList<Word>()
        for (row in dictionaryList) {
            if (matchCriteria == MATCH_BEGINNING && row[0].startsWith(word))
                wordList.add(Word(row[0]))

            if (matchCriteria == MATCH_END && row[0].endsWith(word))
                wordList.add(Word(row[0]))
        }
        return wordList
    }
}