package ca.havensoft.tamilrhymingdictionary.repository

import ca.havensoft.tamilrhymingdictionary.model.Word

class WordListService(private val dictionaryList: List<Array<String>>) {

    fun matchingWordList(word: String): List<Word> {
        val wordList = ArrayList<Word>()
        for (row in dictionaryList) {
            wordList.add(Word(row[0]))
        }
        return wordList
    }
}