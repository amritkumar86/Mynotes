package com.example.mynotes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynotes.Models.NotesData
import com.example.mynotes.utilities.DATABASE_NAME

@Database(entities = arrayOf( NotesData :: class), version = 1, exportSchema = false)
abstract class NotedDataBase : RoomDatabase() {
    abstract fun notesdao():NotesDao

    companion object {
        @Volatile
        private var notesdatabaseinstance: NotedDataBase? = null

        @Synchronized
        fun getInstance(context: Context): NotedDataBase? {

            if (notesdatabaseinstance == null) {
                notesdatabaseinstance = create(context)
            }
            return notesdatabaseinstance
        }


        private fun create(context: Context): NotedDataBase {
            var dbBuilder = Room.databaseBuilder(context, NotedDataBase::class.java, DATABASE_NAME)
            return dbBuilder.build()
        }
    }


}