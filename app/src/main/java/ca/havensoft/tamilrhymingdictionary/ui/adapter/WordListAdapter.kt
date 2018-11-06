package ca.havensoft.tamilrhymingdictionary.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ca.havensoft.tamilrhymingdictionary.R
import ca.havensoft.tamilrhymingdictionary.model.Word
import kotlinx.android.synthetic.main.word_desc_layout.view.*

class WordListAdapter(private val wordsList: List<Word>) : RecyclerView.Adapter<WordListAdapter.WordDescHolder>() {

    override fun getItemCount() = wordsList.size

    override fun onBindViewHolder(holder: WordListAdapter.WordDescHolder, position: Int) {
        val wordItem = wordsList[position]
        holder.bindWord(wordItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListAdapter.WordDescHolder {

        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.word_desc_layout, parent, false)
        return WordDescHolder(inflatedView)
    }

    class WordDescHolder(wordView: View) : RecyclerView.ViewHolder(wordView) {
        private var view = wordView
        private var word: Word? = null

        fun bindWord(word: Word) {
            this.word = word
            view.textViewWordDesc.text = word.tamilScript
        }
    }
}