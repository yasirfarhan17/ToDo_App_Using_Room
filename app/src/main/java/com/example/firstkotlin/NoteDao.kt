package com.example.firstkotlin

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDao {

    @Insert
    suspend fun insert(note:NoteEntity)
    @Delete
    suspend fun delete(note:NoteEntity)

    @Query("Select * from Note_table order by id ASC")
    fun getAllNote() : LiveData<List<NoteEntity>>
}