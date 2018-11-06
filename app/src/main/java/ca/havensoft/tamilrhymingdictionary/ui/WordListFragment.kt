package ca.havensoft.tamilrhymingdictionary.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ca.havensoft.tamilrhymingdictionary.R
import ca.havensoft.tamilrhymingdictionary.viewmodels.WordListViewModel

class WordListFragment : Fragment() {

    companion object {
        fun newInstance() = WordListFragment()
    }

    private lateinit var viewModel: WordListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.word_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WordListViewModel::class.java)
        viewModel.init("blah")
        viewModel.getWordList()
    }

}
