package com.example.firstkotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class NoteViewModel(application: Application) : ViewModel() {

    val repository : NoteRepository
    val allNote : LiveData<List<NoteEntity>>

    init {
        val dao=NoteDatabase.getDatabase(application).getNoteDao()
        repository=NoteRepository(dao)
        allNote=repository.allNotes
    }
    fun delete( note: NoteEntity)=viewModelScope.launch(Dispatchers.IO){
       repository.delete(note)
    }
    fun insert( note: NoteEntity)=viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }
}