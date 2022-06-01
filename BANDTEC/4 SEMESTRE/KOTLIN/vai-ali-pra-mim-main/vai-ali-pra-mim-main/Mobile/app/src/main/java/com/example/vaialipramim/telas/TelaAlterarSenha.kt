package com.example.vaialipramim.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.vaialipramim.R

class TelaAlterarSenha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_alterar_senha)
    }

    fun voltarEditarPerfil(view: View) {
        val voltarEditarPerfil = Intent(this,EditarPerfil::class.java)
        startActivity(voltarEditarPerfil)

    }


    fun salvarAlteracoes(view: View) {}
}