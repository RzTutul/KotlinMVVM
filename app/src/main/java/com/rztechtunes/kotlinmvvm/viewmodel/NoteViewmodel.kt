package com.rztechtunes.kotlinmvvm.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rztechtunes.kotlinmvvm.database.model.NoteBookPojo
import com.rztechtunes.kotlinmvvm.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewmodel(private val noteRepository: NoteRepository): ViewModel() {

    val note = noteRepository.noteList

    @Bindable
    val noteTV= MutableLiveData<String?>()

    fun savedNoteText()
    {
        val note = noteTV.value!!
        insertNote(NoteBookPojo(0,note,"31-03-222"))

        noteTV.value = null
    }

    fun insertNote(noteBookPojo: NoteBookPojo)=viewModelScope.launch {
        noteRepository.InsertNote(noteBookPojo)
    }

}