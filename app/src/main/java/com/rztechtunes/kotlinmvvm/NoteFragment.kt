package com.rztechtunes.kotlinmvvm

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rztechtunes.kotlinmvvm.database.NoteDB
import com.rztechtunes.kotlinmvvm.database.NoteDao
import com.rztechtunes.kotlinmvvm.databinding.FragmentNoteBinding
import com.rztechtunes.kotlinmvvm.repository.NoteRepository
import com.rztechtunes.kotlinmvvm.viewmodel.NoteViewmodel
import com.rztechtunes.kotlinmvvm.viewmodel.NoteViewmodelFactory
import kotlin.math.log

class NoteFragment : Fragment() {
    private lateinit var binding: FragmentNoteBinding
    private lateinit var noteViewmodel: NoteViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(layoutInflater)
        val dao = NoteDB.getInstance(requireContext()).noteDao
        val repository = NoteRepository(dao)
        val factory = NoteViewmodelFactory(repository)
        noteViewmodel= ViewModelProvider(this, factory).get(NoteViewmodel::class.java)
        binding.noteviewmodel  = noteViewmodel
        binding.lifecycleOwner = this
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteViewmodel.note.observe(viewLifecycleOwner, Observer {

            binding.noteTV.text = it.toString()
        })
    }



}