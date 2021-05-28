package com.example.firstkotlin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Note_table")
class NoteEntity(@ColumnInfo(name = "text")val text:String) {

    @PrimaryKey(autoGenerate = true) var id=0
}