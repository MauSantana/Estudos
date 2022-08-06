package com.example.navegacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irTela2(view: View){

        val tela2: Intent = Intent(
            baseContext,
            Tela2::class.java
        )

        tela2.putExtra("nome_usuario", "Joao")
        tela2.putExtra("idade_usuario", 19)
        startActivity(tela2)

    }

    fun contar(view: View){

        contador++
        Toast.makeText(
            baseContext,
            contador.toString(),
            Toast.LENGTH_SHORT).show()

    }
}