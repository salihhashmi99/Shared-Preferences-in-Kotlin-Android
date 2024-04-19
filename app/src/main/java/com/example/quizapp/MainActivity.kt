package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("NoteData", Context.MODE_PRIVATE)

        binding.saveNoteButton.setOnClickListener {
            val note = binding.notesEditText.text.toString()
            val note2 = binding.notes2EditText.text.toString()

            val sharedEdit =sharedPreferences.edit()
            sharedEdit.putString("Notes",note)
            sharedEdit.putString("Notes2",note2)
            sharedEdit.apply()

            Toast.makeText(this,"You saved notes",Toast.LENGTH_SHORT)
            binding.notesEditText.text.clear()
            binding.notes2EditText.text.clear()

            val intent = Intent(this, PreferencesScreen::class.java)
            startActivity(intent)

        }

//        binding.displayNoteButton.setOnClickListener {
//            val storedNote = sharedPreferences.getString("Notes","")
//            val storeNote2 = sharedPreferences.getString("Notes2","")
//            binding.noteTextView.text= "$storedNote"
//            binding.note2TextView.text="$storeNote2"
//        }

    }
}