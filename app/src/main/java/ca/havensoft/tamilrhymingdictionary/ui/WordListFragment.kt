package ca.havensoft.tamilrhymingdictionary.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils

import ca.havensoft.tamilrhymingdictionary.R
import ca.havensoft.tamilrhymingdictionary.application.MATCH_BEGINNING
import ca.havensoft.tamilrhymingdictionary.application.MATCH_END
import ca.havensoft.tamilrhymingdictionary.databinding.WordListFragmentBinding
import ca.havensoft.tamilrhymingdictionary.ui.customviews.ItemOffsetDecoration
import ca.havensoft.tamilrhymingdictionary.ui.adapter.WordListAdapter
import ca.havensoft.tamilrhymingdictionary.util.convertToLatinScript
import ca.havensoft.tamilrhymingdictionary.viewmodels.WordListViewModel

import kotlinx.android.synthetic.main.word_list_fragment.*

class WordListFragment : Fragment() {

    private lateinit var viewModel: WordListViewModel
    private var syllables = 0

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
        word_list_view.addItemDecoration(
            ItemOffsetDecoration(
                resources.getDimensionPixelOffset(R.dimen.default_spacing_small)
            )
        )
        updateSyllablesTextView()
    }

    fun fetchMatchingWords() {
        val matchCriteria = if (radio_group_search_type.checkedRadioButtonId == R.id.radio_button_end) MATCH_END else MATCH_BEGINNING
        viewModel.updateWordList(convertToLatinScript(rhyme_word_input.text.toString()), matchCriteria, syllables)

        viewModel.wordList.observe(viewLifecycleOwner, Observer { wordList ->
            wordList?.let {
                val wordListAdapter = WordListAdapter(it)
                word_list_view.adapter = wordListAdapter
                runLayoutAnimation(word_list_view)
            }
        })
    }

    private fun updateSyllablesTextView() {
        val syllablesString = if (syllables == 0) resources.getString(R.string.syllables) + " All" else resources.getString(R.string.syllables) + " " + syllables
        syllables_text_view.text = syllablesString
    }

    fun trackProgress(progressValue: Int) {
        syllables = progressValue
        updateSyllablesTextView()
    }

    private fun runLayoutAnimation(recyclerView: RecyclerView) {
        val context = recyclerView.context

        val controller = AnimationUtils.loadLayoutAnimation(context, pickAnAnimation())

        recyclerView.layoutAnimation = controller
        recyclerView.adapter!!.notifyDataSetChanged()
        recyclerView.scheduleLayoutAnimation()
    }

    private fun pickAnAnimation(): Int {
        val randomInteger = (1..3).shuffled().first()
        return when (randomInteger) {
            1 -> R.anim.grid_layout_animation_scale_random
            2 -> R.anim.grid_layout_animation_scale
            else -> R.anim.grid_layout_animation_from_bottom
        }
    }

}
