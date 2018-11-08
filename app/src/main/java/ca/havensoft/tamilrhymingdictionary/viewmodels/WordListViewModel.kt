package ca.havensoft.tamilrhymingdictionary.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ca.havensoft.tamilrhymingdictionary.application.injectWordRepo
import ca.havensoft.tamilrhymingdictionary.model.Word
import ca.havensoft.tamilrhymingdictionary.repository.WordRepository
import javax.inject.Inject

class WordListViewModel : ViewModel() {

    @Inject
    lateinit var wordRepo: WordRepository

    val wordList = MutableLiveData<List<Word>>()

    fun updateWordList(wordToBeMatched: String, matchCriteria: Int, syllables: Int) {
        injectWordRepo(this)

        wordRepo.matchingWordList(wordToBeMatched, matchCriteria, syllables) {
            wordList.postValue(it)
        }
    }
}
