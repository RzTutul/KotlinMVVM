package com.rztechtunes.kotlinmvvm.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_tbl")
data class NoteBookPojo(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val note_text:String,
    val date:String
    )
