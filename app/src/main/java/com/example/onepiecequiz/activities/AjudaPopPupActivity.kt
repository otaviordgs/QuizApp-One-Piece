package com.example.onepiecequiz.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import androidx.core.graphics.ColorUtils
import com.example.onepiecequiz.databinding.ActivityAjudaPopPupBinding
import com.example.onepiecequiz.models.PerguntaSingleton

class AjudaPopPupActivity : AppCompatActivity() {
    lateinit var binding: ActivityAjudaPopPupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(0, 0)
        binding = ActivityAjudaPopPupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.botaoDica.setOnClickListener{
            val intent = Intent(this, PerguntasActivity::class.java)
            intent.putExtra("ajuda",1)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

        binding.botaoEliminar.setOnClickListener{
            val intent = Intent(this, PerguntasActivity::class.java)
            intent.putExtra("ajuda",2)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        binding.botaoPular.setOnClickListener{
            val intent = Intent(this, PerguntasActivity::class.java)
            intent.putExtra("ajuda",3)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}