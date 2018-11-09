package ca.havensoft.tamilrhymingdictionary.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ca.havensoft.tamilrhymingdictionary.R
import ca.havensoft.tamilrhymingdictionary.databinding.WordDescLayoutBinding
import ca.havensoft.tamilrhymingdictionary.model.Word

class WordListAdapter(private val wordList: List<Word>) : RecyclerView.Adapter<WordListAdapter.MyViewHolder>() {
    private lateinit var layoutInflater: LayoutInflater

    inner class MyViewHolder(val binding: WordDescLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<WordDescLayoutBinding>(layoutInflater, R.layout.word_desc_layout, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.word = wordList[position]
    }

    override fun getItemCount(): Int {
        return wordList.size
    }
}