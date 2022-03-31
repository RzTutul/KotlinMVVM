package com.rztechtunes.kotlinmvvm.repository

import com.rztechtunes.kotlinmvvm.database.NoteDao
import com.rztechtunes.kotlinmvvm.database.model.NoteBookPojo

class NoteRepository(private val dao: NoteDao) {

    val noteList = dao.getAllNote()

    suspend fun InsertNote(noteBookPojo: NoteBookPojo)
    {
        dao.insertNote(noteBookPojo)
    }
}