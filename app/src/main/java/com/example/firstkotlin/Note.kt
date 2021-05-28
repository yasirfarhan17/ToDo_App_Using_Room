package com.example.firstkotlin

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Note : AppCompatActivity(),NoteRVAdapter.INoteRVAdapter {


    lateinit var viewModel: NoteViewModel
    lateinit var input : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input=findViewById(R.id.nameId)

        val recyclerView=findViewById<RecyclerView>(R.id.RVId)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=NoteRVAdapter(this,this)
        recyclerView.adapter=adapter
        val factory = ViewModelFactory(application)
        viewModel=ViewModelProvider(this,factory).get(NoteViewModel::class.java)
        viewModel.allNote.observe(this, Observer {list ->
        list ?.let{
            adapter.update(it)
        }

        })



    }

    override fun onClickItem(note: NoteEntity) {
        viewModel.delete(note)
        Toast.makeText(this,"${note.text} Deleted",Toast.LENGTH_LONG).show()
    }

    fun submit(view: View) {
        var name=input.text.toString()
        if(name.isNotEmpty())
            viewModel.insert(NoteEntity(name))
             Toast.makeText(this,"${name} Inserted",Toast.LENGTH_LONG).show()
                setTextViewEmpty(input)



    }
    fun setTextViewEmpty(textView: TextView){
        (textView as EditText).text.clear()   }
}
