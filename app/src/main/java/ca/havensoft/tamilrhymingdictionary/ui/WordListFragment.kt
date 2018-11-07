package ca.havensoft.tamilrhymingdictionary.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ca.havensoft.tamilrhymingdictionary.R
import ca.havensoft.tamilrhymingdictionary.application.MATCH_BEGINNING
import ca.havensoft.tamilrhymingdictionary.application.MATCH_END
import ca.havensoft.tamilrhymingdictionary.databinding.WordListFragmentBinding
import ca.havensoft.tamilrhymingdictionary.ui.adapter.WordListAdapter
import ca.havensoft.tamilrhymingdictionary.util.convertToLatinScript
import ca.havensoft.tamilrhymingdictionary.viewmodels.WordListViewModel

import kotlinx.android.synthetic.main.word_list_fragment.*

class WordListFragment : Fragment() {

    private lateinit var viewModel: WordListViewModel

    companion object {
        private const val COLUMNS = 3
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(WordListViewModel::class.java)

        val binding = DataBindingUtil.inflate<WordListFragmentBinding>(
                inflater, R.layout.word_list_fragment, container, false).apply {
            wordListViewModel = viewModel
            wordListFragment = this@WordListFragment
            setLifecycleOwner(this@WordListFragment)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        word_list_view.layoutManager = GridLayoutManager(context, COLUMNS)
    }

    fun fetchMatchingWords() {
        val matchCriteria = if (radio_group_search_type.checkedRadioButtonId == R.id.radio_button_end) MATCH_END else MATCH_BEGINNING
        viewModel.updateWordList(convertToLatinScript(rhyme_word_input.text.toString()), matchCriteria)

        viewModel.wordList.observe(viewLifecycleOwner, Observer { wordList ->
            wordList?.let {
                val wordListAdapter = WordListAdapter(it)
                word_list_view.adapter = wordListAdapter
            }
        })
    }

}
