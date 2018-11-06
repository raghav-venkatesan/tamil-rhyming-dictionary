package ca.havensoft.tamilrhymingdictionary.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import ca.havensoft.tamilrhymingdictionary.application.injectWordRepo
import ca.havensoft.tamilrhymingdictionary.repository.WordRepository
import javax.inject.Inject

class WordListViewModel : ViewModel() {

    @Inject
    lateinit var wordRepo: WordRepository

    private val wordList = MutableLiveData<List<String>>()

    fun init(wordToBeMatched: String) {
        injectWordRepo(this)

        wordRepo.matchingWordList(wordToBeMatched) {
            wordList.postValue(it)
        }
    }

    fun getWordList() = wordList
}
