package com.example.quiz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.quiz.R
import com.example.quiz.databinding.ActivityPerguntasBinding
import com.example.quiz.models.Pergunta
import com.example.quiz.models.PerguntaSingleton

class PerguntasActivity : AppCompatActivity() {
    lateinit var binding: ActivityPerguntasBinding

    private var posicao: Int = 1
    private var questoes: ArrayList<Pergunta>? = null
    private var resposta: Int? = null
    private var alternativas =  ArrayList<Button>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerguntasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questoes = PerguntaSingleton.getPerguntas()
        setPerguntas()

        binding.alternativa1.setOnClickListener {
            if(resposta == alternativas.indexOf(binding.alternativa1)){
                binding.alternativa1.background = R.color.verde
            }
        }
    }

    private fun setPerguntas(){

        posicao = 1
        val pergunta = questoes!![posicao-1]
        resposta = pergunta.resposta
        alternativas.add(1, binding.alternativa1)
        alternativas.add(2, binding.alternativa2)
        alternativas.add(3, binding.alternativa3)
        alternativas.add(4, binding.alternativa4)
        alternativas.add(5, binding.alternativa5)



        binding.pergunta.text = pergunta!!.pergunta
        binding.imagem.setImageResource(pergunta.imagem)
        binding.alternativa1.text = pergunta.alternativaUm
        binding.alternativa2.text = pergunta.alternativaDois
        binding.alternativa3.text = pergunta.alternativaTres
        binding.alternativa4.text = pergunta.alternativaQuatro
        binding.alternativa5.text = pergunta.alternativaCinco
    }

}