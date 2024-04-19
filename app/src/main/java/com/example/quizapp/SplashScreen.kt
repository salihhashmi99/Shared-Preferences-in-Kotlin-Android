package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.quizapp.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.carlottie.setAnimation(R.raw.caranim)
        binding.txtappname.setText("TASK APP")

        val splashScreenDelay = 3000L
        Handler().postDelayed({
                              val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },splashScreenDelay)
    }
}