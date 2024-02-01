package com.example.mynotes.Models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mynotes.Repository.NotesRepository
import com.example.mynotes.database.NotedDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application){
    private var repository: NotesRepository
    val allNotes: LiveData<List<NotesData>>

    init {
        val dao = NotedDataBase.getInstance(application)?.notesdao()
        repository = dao?.let { NotesRepository(it) }!!
        allNotes = repository.getAll()
    }

    fun deleteNote(notesData: NotesData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(notesData)
        }
    }

    fun insertNote(notesData: NotesData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(notesData)
        }
    }

    fun updateNote(notesData: NotesData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(notesData)
        }
    }

}