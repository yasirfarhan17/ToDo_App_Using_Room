package com.example.firstkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(var context: Context, var listner: INoteRVAdapter): RecyclerView.Adapter<NoteRVAdapter.NoteViewHolder>() {

    val allNote= ArrayList<NoteEntity>()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textView = itemView.findViewById<TextView>(R.id.name)
        val Button=itemView.findViewById<ImageView>(R.id.delete);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val veiwHolder=NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false))
          veiwHolder.Button.setOnClickListener{
              listner.onClickItem(allNote[veiwHolder.adapterPosition])
          }
        return  veiwHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote=allNote[position]
        holder.textView.text=currentNote.text
    }

    fun update(newList:List<NoteEntity>){
        allNote.clear()
        allNote.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return allNote.size
    }

    interface  INoteRVAdapter{
        fun onClickItem(note:NoteEntity)
    }

}