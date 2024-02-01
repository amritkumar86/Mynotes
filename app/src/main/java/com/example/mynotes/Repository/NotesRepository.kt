package com.example.mynotes.Repository

import android.widget.Toast
import androidx.lifecycle.LiveData
import com.example.mynotes.Models.NotesData
import com.example.mynotes.database.NotesDao

class NotesRepository(private  val db : NotesDao) {



     fun getAll():LiveData<List<NotesData>> {
        val alldata: LiveData<List<NotesData>> = db.getall()
        return alldata
    }

    suspend fun insert(notesData: NotesData)
    {
        db.insert(notesData)
    }
    suspend fun delete(notesData :NotesData)
    {
       db.delete(notesData)
    }

    suspend fun update(notesData: NotesData)
    {
        var id = notesData.id
        var title = notesData.title
        var notes = notesData.notes

        if(id!=null && title!= null && notes!=null)
        {
            db.update(id,title,notes)
        }
    }

}