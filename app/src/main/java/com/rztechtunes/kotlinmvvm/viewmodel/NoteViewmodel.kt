package com.rztechtunes.kotlinmvvm.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.textfield.TextInputLayout
import com.rztechtunes.kotlinmvvm.database.model.NoteBookPojo
import com.rztechtunes.kotlinmvvm.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewmodel(private val noteRepository: NoteRepository): ViewModel(),Observable {

    val note = noteRepository.noteList

    @Bindable
    val noteTV= MutableLiveData<String?>()



    fun savedNoteText()
    {
        val note = noteTV.value
        if(note!=null)
        {
            insertNote(NoteBookPojo(0,note,"31-03-222"))
        }
        else
        {

        }


        noteTV.value = null
    }

    fun insertNote(noteBookPojo: NoteBookPojo)=viewModelScope.launch {
        noteRepository.InsertNote(noteBookPojo)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    @BindingAdapter("app:errorText")
    fun setErrorText(view: TextInputLayout, errorMessage: String) {
        if (errorMessage.isEmpty())
            view.error = null
        else
            view.error = errorMessage;
    }

}