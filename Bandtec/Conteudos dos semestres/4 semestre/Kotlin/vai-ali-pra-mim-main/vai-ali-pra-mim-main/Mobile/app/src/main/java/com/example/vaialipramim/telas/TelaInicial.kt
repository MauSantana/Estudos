package com.example.vaialipramim.telas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.vaialipramim.R

class TelaInicial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tela_inicial)
    }

    fun irTelaLogin(view: View) {
        val telaLogin= Intent(this, TelaLogin::class.java)
        startActivity(telaLogin);
    }

    fun irTelaCadastro(view: View) {
            val telaCadastro = Intent(this, Cadastro::class.java)
        startActivity(telaCadastro);
    }
}