package ca.havensoft.tamilrhymingdictionary.repository

import ca.havensoft.tamilrhymingdictionary.model.Word

class WordListService(private val dictionaryList: List<Array<String>>) {

    fun matchingWordList(word: String): List<String> {
        val wordList = ArrayList<String>()
        for (row in dictionaryList) {
            if (row[0].endsWith(word))
                wordList.add(Word(row[0]).inTamilScript)
        }
        return wordList
    }
}