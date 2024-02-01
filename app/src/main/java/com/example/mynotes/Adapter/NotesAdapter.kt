package com.example.mynotes.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.Models.NotesData
import com.example.mynotes.R
import java.util.Locale
import kotlin.random.Random

class NotesAdapter(private val context: Context ):
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    private var noteslist = ArrayList<NotesData>()
    private var fulllist = ArrayList<NotesData>()







     inner class  NotesViewHolder(itemView : View):RecyclerView.ViewHolder(itemView)
     {

//         val cardlayout = itemView.findViewById<TextView>(R.id.notecardlayout)
         val title = itemView.findViewById<TextView>(R.id.title)
         val notes = itemView.findViewById<TextView>(R.id.notes)
         val date = itemView.findViewById<TextView>(R.id.date)


     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
       return NotesViewHolder(
           LayoutInflater.from(context).inflate(R.layout.item_notes,parent,false)
       )
    }

    override fun getItemCount(): Int {
//        Toast.makeText(context, "getcontent + ${noteslist.size}", Toast.LENGTH_SHORT).show()
        return noteslist.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        var currentNotes = noteslist[position]

        holder.title.text = currentNotes.title
        holder.notes.text = currentNotes.notes
        holder.date.text = currentNotes.date
        holder.title.isSelected = true
        holder.date.isSelected = true
        Toast.makeText(context, "${currentNotes.title}", Toast.LENGTH_SHORT).show()
//        holder.cardlayout.setCardBackGroundColor
//        holder.cardlayout.setOnClickListener {
//          listener.onItemClicked(noteslist[holder.adapterPosition])
//        }
//        holder.cardlayout.setOnLongClickListener {
//            listener.onLongItemClicked(noteslist[holder.adapterPosition],holder.cardlayout)
//            true
//        }

    }
    fun updateList(newlist:List<NotesData>) {
        fulllist.clear()
        fulllist.addAll(newlist)
        noteslist.clear()
        noteslist.addAll(fulllist)
//        Toast.makeText(context, "updatelist function", Toast.LENGTH_SHORT).show()

        notifyDataSetChanged()
    }
//    fun searchNotes(search: String) {
//
//        noteslist.clear()
//        val searchQuery = search.toLowerCase(Locale.ROOT)
//
//        val filteredList = mutableListOf<NotesData>()
//
//        for (item in fulllist) {
//            val title = item.title?.toLowerCase(Locale.ROOT)
//            val note = item.notes?.toLowerCase(Locale.ROOT)
//
//            if (title?.contains(searchQuery) == true || note?.contains(searchQuery) == true) {
//                noteslist.add(item)
//            }
//        }
//        notifyDataSetChanged()
//
//        // Use the filteredList as needed
//    }

//    fun randomColor():Int{
//
//        var list=  ArrayList<Int>()
//        list.add(R.color.notes1)
//        list.add(R.color.notes2)
//        list.add(R.color.notes3)
//        list.add(R.color.notes4)
//        list.add(R.color.notes5)
//        list.add(R.color.notes6)
//
//        val seed = System.currentTimeMillis().toInt()
//        var randomindex = Random(seed).nextInt(list.size)
//        return list[randomindex]
//
//    }
//    interface notesClickListener {
//        fun onItemClicked(notesData: NotesData)
//        fun onLongItemClicked(notesData: NotesData, cardView: TextView)
//    }


}