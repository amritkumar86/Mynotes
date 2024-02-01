package com.example.mynotes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mynotes.Models.NotesData

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notes :NotesData)

    @Delete
    suspend fun delete(notes: NotesData)


   @Query("UPDATE notes_table Set Title = :title , note= :notes  WHERE id = :id")
    suspend fun update(id:Int,title:String,notes:String)

    @Query("select * from notes_table order by id ASC")
     fun getall():LiveData<List<NotesData>>



}