package com.example.quizapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityPreferencesScreenBinding

class PreferencesScreen : AppCompatActivity() {
    private lateinit var binding: ActivityPreferencesScreenBinding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPreferencesScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("NoteData",Context.MODE_PRIVATE)

        binding.displayNoteButton.setOnClickListener {
            val storedNote = sharedPreferences.getString("Notes","")
            val storeNote2 = sharedPreferences.getString("Notes2","")
            binding.noteTextView.text= "$storedNote"
            binding.note2TextView.text="$storeNote2"
        }
    }
}