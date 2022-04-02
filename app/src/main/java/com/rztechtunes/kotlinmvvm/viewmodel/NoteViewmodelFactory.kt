package com.rztechtunes.kotlinmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rztechtunes.kotlinmvvm.repository.NoteRepository
import java.lang.IllegalArgumentException

class NoteViewmodelFactory(val noteRepository: NoteRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(NoteViewmodel::class.java))
        {
            return NoteViewmodel(noteRepository) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }

}