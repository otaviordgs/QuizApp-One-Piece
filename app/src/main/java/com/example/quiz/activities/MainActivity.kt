package com.example.quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quiz.R
import com.example.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoIniciar.setOnClickListener {
            val intent = Intent(this, PerguntasActivity::class.java)
            startActivity(intent)
            finish()
        }



    }
}