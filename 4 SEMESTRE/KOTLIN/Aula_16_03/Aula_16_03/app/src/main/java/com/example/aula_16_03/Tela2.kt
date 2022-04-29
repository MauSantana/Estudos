package com.example.aula_16_03

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Tela2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)
        val nome = intent.getStringExtra(
            "nome_usuario"
        )
        val idade = intent.getIntExtra(
            "idade_usuario",
            0
        )
        findViewById<TextView>(R.id.tv_frase).text =
            "Olá $nome, sua idade é $idade"
    }

    fun voltar(view: View) {
        startActivity(
            Intent(
                baseContext,
                MainActivity::class.java
            )
        )
    }
}