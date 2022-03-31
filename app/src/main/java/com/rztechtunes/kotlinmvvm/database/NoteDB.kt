package com.rztechtunes.kotlinmvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rztechtunes.kotlinmvvm.database.model.NoteBookPojo

@Database(entities =[NoteBookPojo::class],version = 1)
abstract class NoteDB : RoomDatabase() {
    abstract val noteDao:NoteDao

    companion object{
        private var INSTANCE : NoteDB?=null

        fun getInstance(context:Context):NoteDB{
            synchronized(this){
                var instance: NoteDB? = INSTANCE
                if (instance==null)
                {
                    instance = Room.databaseBuilder(context.applicationContext,
                        NoteDB::class.java,"notebook_db").build()
                }
                return instance
            }

        }
    }
}