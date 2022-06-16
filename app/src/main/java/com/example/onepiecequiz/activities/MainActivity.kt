package com.example.onepiecequiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.onepiecequiz.R
import com.example.onepiecequiz.databinding.ActivityMainBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (getCurrentUser() == null){
            val providers = arrayListOf(AuthUI.IdpConfig.EmailBuilder().build())

            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers).build(),1)
        }
        binding.botaoIniciar.setOnClickListener {
            val intent = Intent(this, PerguntasActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun getCurrentUser(): FirebaseUser? {
        return FirebaseAuth.getInstance().currentUser
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1 && resultCode == RESULT_OK){
            Toast.makeText(this,"Usuario autenticado", Toast.LENGTH_LONG).show()
        }
        else{
            finishAffinity()
        }
    }
}