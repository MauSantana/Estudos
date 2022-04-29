package com.example.exercicio

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

    fun banana(view: View){

        contador++
        Toast.makeText(
            baseContext,
            contador.toString(),
            Toast.LENGTH_SHORT).show()

        val valorBanana = 0.5;
        val totalBanana = valorBanana * contador;
        val tela2: Intent = Intent(
            baseContext,
            Tela2::class.java
        )
        startActivity(tela2)

//        tela2.putExtra(findViewById<EditText>(R.id.et_nome).text.toString())

    }
    fun pera(view: View){

        val tela2: Intent = Intent(
            baseContext,
            Tela2::class.java
        )
        startActivity(tela2)


    }
    fun uva(view: View){

        val tela2: Intent = Intent(
            baseContext,
            Tela2::class.java
        )
        startActivity(tela2)


    }
    fun maca(view: View){

        val tela2: Intent = Intent(
            baseContext,
            Tela2::class.java
        )
        startActivity(tela2)

    }
}