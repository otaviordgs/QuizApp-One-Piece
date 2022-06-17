package com.example.onepiecequiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.example.onepiecequiz.databinding.ActivityListarJogadoresBinding
import com.example.onepiecequiz.databinding.CardBinding
import com.example.onepiecequiz.models.Pontuacao
import com.example.room.Jogador
import com.example.room.MainDatabase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ListarJogadoresActivity : AppCompatActivity() {
    lateinit var binding: ActivityListarJogadoresBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarJogadoresBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPontuacoes()

        binding.botaoVoltar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun getPontuacoes(){
        val thread = Thread {
            var db = Room.databaseBuilder(this, MainDatabase::class.java, "AppDb").build()
            var pontuacoes = db.jogadorDao().getAll()
            runOnUiThread {
                binding.container.removeAllViews()
                pontuacoes.forEach{
                    val cardBinding = CardBinding.inflate(layoutInflater)
                    cardBinding.txtnome.text = it.nome.toString()
                    cardBinding.txtpontuacao.text = it.pontuacao.toString()
                    binding.container.addView(cardBinding.root)
                }
            }
        }
        thread.start()
    }


}