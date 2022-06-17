package com.example.onepiecequiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.onepiecequiz.R
import com.example.onepiecequiz.databinding.ActivityFinalBinding
import com.example.onepiecequiz.models.Pergunta
import com.example.onepiecequiz.models.PerguntaSingleton
import com.example.onepiecequiz.models.Pontuacao
import com.example.room.Jogador
import com.example.room.MainDatabase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FinalActivity : AppCompatActivity() {
    lateinit var binding: ActivityFinalBinding
    lateinit var database: DatabaseReference
    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setupFirebase()
        setContentView(binding.root)
        val user = FirebaseAuth.getInstance().currentUser
        val Acertos = intent.getIntExtra(PerguntaSingleton.Pontos, 0)

        binding.txtResultado.text = "Você acertou $Acertos de 10."

        binding.btnSalvar.setOnClickListener(){
            //insert(Acertos)
            insertRoom(Acertos)
            voltarMenu()
        }
        binding.btnVoltar.setOnClickListener(){
            voltarMenu()
        }
        var msg = ""

        if(Acertos <= 3){
            binding.imagem.setBackgroundResource((R.drawable.luffysad))
            msg = "Vish, assiste mais uns 200 ep que você melhora"
        }
        else if(Acertos in 4..9){
            binding.imagem.setBackgroundResource((R.drawable.ussop))
            msg = "Quase! Só mais um pouquinho"
        }
        else{
            binding.imagem.setBackgroundResource((R.drawable.nami))
            msg = "Parabéns! Você acertou tudo!"
        }

        if (user != null) {
            msg += "\n${user.displayName}"
        }
        binding.txtUsuario.text = msg
    }

    fun voltarMenu(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun setupFirebase(){
        if (user != null) {
            database = FirebaseDatabase.getInstance().reference.child(user.uid)
        }
    }

    fun insertRoom(pont: Int){
        val pontuacao = Pontuacao(usuario = user?.displayName.toString(), pontuacao = pont.toString())
        val jogador = Jogador(nome = pontuacao.usuario, pontuacao = pontuacao.pontuacao)
        val thread = Thread {
            var db = Room.databaseBuilder(this, MainDatabase::class.java, "AppDb").build()
            var antigo = db.jogadorDao().getByUser(nome = jogador.nome)
            if(antigo != null){
                if(jogador.pontuacao.toString().toInt() > antigo.pontuacao.toString().toInt()) {
                    antigo.pontuacao = jogador.pontuacao
                    db.jogadorDao().update(antigo)
                }
            }
            else{
                db.jogadorDao().insert(jogador)
            }
        }
        thread.start()
    }

}