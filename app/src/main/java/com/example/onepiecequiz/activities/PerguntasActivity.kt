package com.example.onepiecequiz.activities

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.onepiecequiz.R
import com.example.onepiecequiz.databinding.ActivityPerguntasBinding
import com.example.onepiecequiz.models.Pergunta
import com.example.onepiecequiz.models.PerguntaSingleton


class PerguntasActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var binding: ActivityPerguntasBinding

    private var posicaoAtual: Int = 1
    private var questoes: ArrayList<Pergunta>? = null
    private var botaoSelecionado: Int = 0
    private var Acertos: Int = 0
    private var selecionou: Int = 0
    private var tipoAjuda: Int? = 0
    private var ActivityRequestReturn = 1


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
        binding.botaoAvancar.setOnClickListener(this)
        binding.botaoDesistir.setOnClickListener(this)
        binding.botaoAjuda.setOnClickListener(this)

    }
    private fun setPerguntas(){
        val pergunta = questoes!![posicaoAtual-1]
        defautButtons()
        if (posicaoAtual == questoes!!.size) {
            binding.botaoAvancar.text = "Acabar"
        } else {
            binding.botaoAvancar.text = "Avançar"
        }
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
            binding.botaoAjuda.id ->{
                val intent = Intent(this, AjudaPopPupActivity::class.java)
                startActivityForResult(intent,1)
                binding.botaoAjuda.isClickable = false

            }
            binding.botaoDesistir.id->{
                Acertos = 0
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            binding.botaoAvancar.id ->{
                if(selecionou == 0){
                    Toast.makeText(this,"Selecione uma opção",Toast.LENGTH_LONG).show()
                }
                else{
                    if(botaoSelecionado == 0){
                        posicaoAtual++
                        if(posicaoAtual <= questoes!!.size){
                            setPerguntas()
                            ableButtons()
                        }
                        else{
                            val intent = Intent(this, FinalActivity::class.java)
                            intent.putExtra(PerguntaSingleton.Pontos,Acertos)
                            startActivity(intent)
                            finish()
                        }
                    }else{
                        val question = questoes?.get(posicaoAtual - 1)
                        if(question!!.resposta != botaoSelecionado){
                            checkAnswer(botaoSelecionado,R.drawable.wrong_option_border_bg)
                        }else{
                            Acertos++
                        }
                        checkAnswer(question!!.resposta,R.drawable.correct_option_border_bg)
                        if(posicaoAtual == questoes!!.size){
                            binding.botaoAvancar.text = "Acabar"
                        }else{
                            binding.botaoAvancar.text = "Avançar"
                        }
                        botaoSelecionado = 0
                        disableButtons()
                    }
                }
            }
        }
    }

    // This method is called when the second activity finishes
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Check that it is the SecondActivity with an OK result
        if (requestCode == ActivityRequestReturn) {
            if (resultCode == Activity.RESULT_OK) {

                // Get String data from Intent
                tipoAjuda = data?.getIntExtra("ajuda", 10)
                val pergunta = questoes!![posicaoAtual-1]
                if(tipoAjuda == 1){
                    Toast.makeText(this,pergunta.dica,Toast.LENGTH_LONG).show()
                }
                else if(tipoAjuda == 2){
                    val err = questoes?.get(pergunta!!.resposta + 1)
                    checkAnswer(err!!.resposta, R.drawable.wrong_option_border_bg)
                }
                else{
                    posicaoAtual++
                    if(posicaoAtual <= questoes!!.size){
                        setPerguntas()
                        ableButtons()
                    }
                    else{
                        val intent = Intent(this, FinalActivity::class.java)
                        intent.putExtra(PerguntaSingleton.Pontos,Acertos)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }

    private fun disableButtons(){
        binding.alternativa1.isClickable = false
        binding.alternativa2.isClickable = false
        binding.alternativa3.isClickable = false
        binding.alternativa4.isClickable = false
        binding.alternativa5.isClickable = false
        binding.botaoDesistir.isClickable = false
        binding.botaoAjuda.isClickable = false
    }

    private fun ableButtons(){
        selecionou = 0
        binding.alternativa1.isClickable = true
        binding.alternativa2.isClickable = true
        binding.alternativa3.isClickable = true
        binding.alternativa4.isClickable = true
        binding.alternativa5.isClickable = true
        binding.botaoDesistir.isClickable = true
        binding.botaoAjuda.isClickable = true
    }
    private fun selectedButton(button: Button,selectedOption: Int){
        selecionou = 1
        defautButtons()
        botaoSelecionado = selectedOption
        button.setTextColor(Color.parseColor("#363A43"))
        button.setTypeface(button.typeface,Typeface.BOLD)
        button.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border_bg)
    }

    private fun checkAnswer(res : Int,drawableView: Int){
        when(res){
            1 ->{
                binding.alternativa1.background = ContextCompat.getDrawable(
                    this,drawableView)
            }
            2 ->{
                binding.alternativa2.background = ContextCompat.getDrawable(
                    this,drawableView)
            }
            3 ->{
                binding.alternativa3.background = ContextCompat.getDrawable(
                    this,drawableView)
            }
            4 ->{
                binding.alternativa4.background = ContextCompat.getDrawable(
                    this,drawableView)
            }
            5 ->{
                binding.alternativa5.background = ContextCompat.getDrawable(
                    this,drawableView)
            }
        }
    }

}