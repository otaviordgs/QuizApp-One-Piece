package com.example.onepiecequiz.activities

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.onepiecequiz.R
import com.example.onepiecequiz.databinding.ActivityPerguntasBinding
import com.example.onepiecequiz.models.Pergunta
import com.example.onepiecequiz.models.PerguntaSingleton

class PerguntasActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var binding: ActivityPerguntasBinding

    private var posicao: Int = 1
    private var questoes: ArrayList<Pergunta>? = null
    private var respostaSelecinada: Int? = 0
    private var alternativas =  ArrayList<Button>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerguntasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questoes = PerguntaSingleton.getPerguntas()
        setPerguntas()

        binding.alternativa1.setOnClickListener(this)
        binding.alternativa2.setOnClickListener(this)
        binding.alternativa3.setOnClickListener(this)
        binding.alternativa4.setOnClickListener(this)
        binding.alternativa5.setOnClickListener(this)

    }

    private fun setPerguntas(){
        posicao = 1
        val pergunta = questoes!![posicao-1]
        defautButtons()
        respostaSelecinada = pergunta.resposta
        binding.pergunta.text = pergunta.pergunta
        binding.imagem.setImageResource(pergunta.imagem)
        binding.alternativa1.text = pergunta.alternativaUm
        binding.alternativa2.text = pergunta.alternativaDois
        binding.alternativa3.text = pergunta.alternativaTres
        binding.alternativa4.text = pergunta.alternativaQuatro
        binding.alternativa5.text = pergunta.alternativaCinco
    }

   private fun defautButtons(){
       val opcoes = ArrayList<Button>()
       opcoes.add(0,binding.alternativa1)
       opcoes.add(1,binding.alternativa2)
       opcoes.add(2,binding.alternativa3)
       opcoes.add(3,binding.alternativa4)
       opcoes.add(4,binding.alternativa5)

       for (op in opcoes){
           op.setTextColor(Color.parseColor("#c4c4c4"))
           op.typeface = Typeface.DEFAULT
           op.background = ContextCompat.getDrawable(this,
               R.drawable.default_option_border_bg)
       }
   }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.alternativa1.id ->{
                selectedButton(binding.alternativa1,1)
            }
            binding.alternativa2.id ->{
                selectedButton(binding.alternativa2,2)
            }
            binding.alternativa3.id ->{
                selectedButton(binding.alternativa3,3)
            }
            binding.alternativa4.id ->{
                selectedButton(binding.alternativa4,4)
            }
            binding.alternativa5.id ->{
                selectedButton(binding.alternativa5,5)
            }
        }
    }
    private fun selectedButton(button: Button,selectedOption: Int){
        defautButtons()
        posicao = selectedOption
        button.setTextColor(Color.parseColor("#363A43"))
        button.setTypeface(button.typeface,Typeface.BOLD)
        button.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border_bg)
    }
}