package com.example.mynotes

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mynotes.Models.NoteViewModel
import com.example.mynotes.Models.NotesData
import com.example.mynotes.databinding.ActivityNotestakingBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Notestaking : AppCompatActivity() {

    private lateinit var binding: ActivityNotestakingBinding
    private lateinit var notesdata:NotesData
    private lateinit var viewModel: NoteViewModel

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNotestakingBinding.inflate(layoutInflater)
        setContentView(binding.root)
      viewModel = ViewModelProvider(this,
          ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        binding.save.setOnClickListener {
            val title = binding.entertitle.text.toString()
            val note = binding.enternotes.text.toString()

            if(title.isNotEmpty()||note.isNotEmpty())
            {
                val pattern = "yyyy-MM-dd HH:mm:ss"
                Toast.makeText(this, "savae ntm", Toast.LENGTH_SHORT).show()
                val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())


                viewModel.insertNote(NotesData(1,title,note,dateFormat.toString()))
//                val intent = Intent(this,MainActivity::class.java)
//                intent.putExtra("id",0)
//                intent.putExtra("title",title)
//                intent.putExtra("notes",note)
//                intent.putExtra("date",dateFormat.toString())
//                Toast.makeText(this@Notestaking, "$title + $note ", Toast.LENGTH_SHORT).show()
//                setResult(Activity.RESULT_OK,intent)
                startActivity(Intent(applicationContext, MainActivity::class.java))
                this.finish()

            }

        }
        binding.back.setOnClickListener {
            onBackPressed()
        }

    }

}