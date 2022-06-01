package com.example.vaialipramim.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.vaialipramim.R

class EsqueceuSenha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueceu_senha)
    }

    fun voltarLogin(view: View) {
        val voltar = Intent(this, TelaLogin::class.java)
        startActivity(voltar)
    }

}