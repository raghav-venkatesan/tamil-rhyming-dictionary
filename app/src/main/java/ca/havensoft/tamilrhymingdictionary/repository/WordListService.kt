package ca.havensoft.tamilrhymingdictionary.repository

import ca.havensoft.tamilrhymingdictionary.application.MATCH_BEGINNING
import ca.havensoft.tamilrhymingdictionary.application.MATCH_END
import ca.havensoft.tamilrhymingdictionary.model.Word

class WordListService(private val dictionaryList: List<Array<String>>) {

    fun matchingWordList(word: String, matchCriteria: Int, syllables: Int): List<Word> {
        val wordList = ArrayList<Word>()
        for (row in dictionaryList) {
            if (matchCriteria == MATCH_BEGINNING && row[0].startsWith(word)) {
                if (syllables == 0)
                    wordList.add(Word(row[0], row[1], row[2]))
                else if (row[2] == syllables.toString())
                    wordList.add(Word(row[0], row[1], row[2]))
            }

            if (matchCriteria == MATCH_END && row[0].endsWith(word)) {
                if (syllables == 0)
                    wordList.add(Word(row[0], row[1], row[2]))
                else if (row[2] == syllables.toString())
                    wordList.add(Word(row[0], row[1], row[2]))
            }
        }
        return wordList
    }
}