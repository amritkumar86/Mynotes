package com.example.mynotes

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mynotes.Adapter.NotesAdapter
import com.example.mynotes.Models.NoteViewModel
import com.example.mynotes.Models.NotesData
import com.example.mynotes.database.NotedDataBase
import com.example.mynotes.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: NotedDataBase
    private lateinit var viewHolder: NotesAdapter.NotesViewHolder
    private lateinit var adapter: NotesAdapter
    private lateinit var viewModel:NoteViewModel
    lateinit var selectedNote : NotesData

//    private  val updateNote  = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
//    { result ->
//        Toast.makeText(this, "update note start manin activity", Toast.LENGTH_SHORT).show()
//        if (result.resultCode == Activity.RESULT_OK) {
//            val data = result.data
//            val id = data?.getIntExtra("id", -1)
//            val title = data?.getStringExtra("title")
//            val notes = data?.getStringExtra("notes")
//            val date = data?.getStringExtra("date")
//            Toast.makeText(this, "$title + $notes + $id + $notes", Toast.LENGTH_SHORT).show()
//            if (id != null && title != null && notes != null && date != null) {
//                val note = NotesData(id, title, notes, date)
//                viewModel.insertNote(note)
//            }
//
//        }
//
//    }
//private val getContent =
//    registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            val data = result.data
//            val id = data?.getIntExtra("id", -1)
//            val title = data?.getStringExtra("title")
//            val notes = data?.getStringExtra("notes")
//            val date = data?.getStringExtra("date")
//            val note = date?.let { NotesData(id, title, notes, it) }
//            if (note != null) {
//                Toast.makeText(this, "$title + $notes + $id", Toast.LENGTH_SHORT).show()
//                viewModel.insertNote(note)
//            }
//        }
//    }
//


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()


         viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)

        (viewModel as NoteViewModel).allNotes.observe(this)
        {
            list->
            list.let {
                adapter.updateList(list)
            }
        }
        database = NotedDataBase.getInstance(this)!!


        binding.animationView.setOnClickListener {
            var intent  = Intent(this,Notestaking::class.java)
            startActivity(intent)

        }


        binding.searchbar.setOnQueryTextListener( object  : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
          }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText!=null)
                {
//                    adapter.searchNotes(newText)
                }
                return true
            }
        }

        )

    }

    private fun initUI()
    {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,LinearLayout.VERTICAL)
        adapter = NotesAdapter(this)
        binding.recyclerView.adapter = adapter

//        Toast.makeText(this, "inituisecond time", Toast.LENGTH_SHORT).show()
//        var getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
//        {
//            result->
//
//            Toast.makeText(this, "inside get content", Toast.LENGTH_SHORT).show()
//
//            if(result.resultCode == Activity.RESULT_OK) {
//                val data = result.data
//                val id = data?.getIntExtra("id", -1)
//                val title = data?.getStringExtra("title")
//                val notes = data?.getStringExtra("notes")
//                val date = data?.getStringExtra("date")
//                var note = date?.let { NotesData(id,title,notes, it) }
//                if(note!=null)
//                {
//                    Toast.makeText(this, " $title + $notes + $id", Toast.LENGTH_SHORT).show()
//                    (viewModel as NoteViewModel).insertNote(note)
//                }
//            }
//
//        }
//        Toast.makeText(this, "outside get", Toast.LENGTH_SHORT).show()




    }

//    override fun onItemClicked(notesData: NotesData) {
//
//        val intent = Intent(this@MainActivity,Notestaking::class.java)
//       val noteobj  = NotesData(notesData.id,notesData.title,notesData.notes,notesData.date)
//        intent.putExtra("id",noteobj.id)
//        intent.putExtra("title",noteobj.title)
//
//        intent.putExtra("notes",noteobj.notes)
//        intent.putExtra("date",noteobj.date)
////       updateNote.launch(intent)
//
//    }
//
//    override fun onLongItemClicked(notesData: NotesData, cardView: TextView) {
//        TODO("Not yet implemented")
//    }


//    override fun onLongItemClicked(notesData: NotesData, cardView: TextView) {
//        selectedNote = notesData
//        popUpdisplay(cardView)
//    }
//    @RequiresApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
//    @android.support.annotation.RequiresApi(Build.VERSION_CODES.HONEYCOMB)
//    private  fun  popUpdisplay(cardView: TextView)
//    {
//        val popup = PopupMenu(this, cardView).also {
//            it.setOnMenuItemClickListener(this@MainActivity)
//            it.inflate(R.menu.pop_up_menu)
//            it.show()
//        }
//    }




}