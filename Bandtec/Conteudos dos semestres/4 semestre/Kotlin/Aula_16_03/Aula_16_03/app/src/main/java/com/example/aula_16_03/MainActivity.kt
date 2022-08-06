package com.example.aula_16_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irTela2(view: View) {
        val tela2: Intent = Intent(
            baseContext,
            Tela2::class.java
        )
        tela2.putExtra("nome_usuario", "Caio")
        tela2.putExtra("idade_usuario", 26)
        startActivity(tela2)
    }
}