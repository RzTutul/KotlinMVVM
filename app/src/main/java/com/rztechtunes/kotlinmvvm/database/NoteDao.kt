package com.rztechtunes.kotlinmvvm.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rztechtunes.kotlinmvvm.database.model.NoteBookPojo

@Dao
interface NoteDao {

    @Insert()
    suspend fun insertNote(noteBookPojo: NoteBookPojo):Long

    @Update()
    suspend fun updateNote(noteBookPojo: NoteBookPojo)

    @Delete()
    suspend fun deleteNote(noteBookPojo: NoteBookPojo)


    @Query("select * from note_tbl order by id desc")
    fun getAllNote():LiveData<List<NoteBookPojo>>

}