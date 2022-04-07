package com.rztechtunes.kotlinmvvm.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rztechtunes.kotlinmvvm.database.model.NoteBookPojo
import com.rztechtunes.kotlinmvvm.databinding.RowNoteBinding

class NoteAdapter(private val notelist:List<NoteBookPojo>):RecyclerView.Adapter<noteviewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteviewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowNoteBinding.inflate(layoutInflater,parent,false)
       return noteviewHolder(binding)
    }

    override fun onBindViewHolder(holder: noteviewHolder, position: Int) {
       holder.bind(notelist[position])
    }

    override fun getItemCount(): Int {

        Log.i(TAG, "getItemCount: "+notelist.size)
        
        return notelist.size
    }


}

class noteviewHolder(val binding:RowNoteBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(noteBookPojo: NoteBookPojo)
    {
        binding.textView.text = noteBookPojo.note_text
        binding.dateTV.text = noteBookPojo.date
    }

}