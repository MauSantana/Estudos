package com.example.exercicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

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
        findViewById<TextView>(R.id.).text =
            "Olá $nome, sua idade é $idade"
    }

    fun voltar(view: View){

        startActivity(Intent(
            baseContext,
            MainActivity::class.java
        ))

    }
}