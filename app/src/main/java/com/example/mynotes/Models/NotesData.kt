package com.example.mynotes.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class NotesData (
       @PrimaryKey(autoGenerate = true) var id:Int?,
      @ColumnInfo(name = "Title") var title:String?,
      @ColumnInfo(name = "note") var notes:String?,
       @ColumnInfo(name = "date")var date:String
        )
