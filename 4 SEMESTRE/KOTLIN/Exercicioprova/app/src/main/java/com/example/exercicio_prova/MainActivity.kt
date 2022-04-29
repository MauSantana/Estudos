package com.example.exercicio_prova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var container: LinearLayout
    private lateinit var time: EditText
    private lateinit var segundoTime: EditText

    private var contadorUm: Int = 0
    private var contadorDois: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        container = findViewById(R.id.layout_container)
        time = findViewById(R.id.et_timeUm)
        segundoTime = findViewById(R.id.et_timeDois)

        findViewById<EditText>(R.id.et_timeUm).visibility =
            View.VISIBLE
        findViewById<EditText>(R.id.et_timeDois).visibility =
            View.VISIBLE
        findViewById<Button>(R.id.bt_golTimeUm).visibility =
            View.GONE
        findViewById<Button>(R.id.bt_golTimeDois).visibility =
            View.GONE
        findViewById<Button>(R.id.bt_encerrar).visibility =
            View.GONE
    }

    fun inicio(v: View) {
//
//        val PrimeiroTime = findViewById<EditText>(R.id.et_timeUm)
//        val SegundoTime = findViewById<EditText>(R.id.et_timeDois)

//        if (camposValidos(primeiroCandidato, segundoCandidato,nomeSegundoCandidato,nomePrimeiroCandidato )) {
//            calcularVotacao()

            findViewById<EditText>(R.id.et_timeUm).visibility =
                View.GONE
            findViewById<EditText>(R.id.et_timeDois).visibility =
                View.GONE
            findViewById<Button>(R.id.bt_golTimeUm).visibility =
                View.VISIBLE
            findViewById<Button>(R.id.bt_golTimeDois).visibility =
                View.VISIBLE
//        }

    }

    fun golTimeUm(v: View) {
        val textView = TextView(baseContext)
        textView.text = getString(R.string.timeUm, time.text.toString())
        textView.setTextColor(getColor(R.color.verde))
        container.addView(textView)

        contadorUm ++
        if (contadorUm >= 3) {
            findViewById<Button>(R.id.bt_encerrar).visibility =
                View.VISIBLE
        }
    }

    fun golTimeDois(v: View) {
        val textView = TextView(baseContext)
        textView.text = getString(R.string.timeDois, segundoTime.text.toString())
        textView.setTextColor(getColor(R.color.vermelho))
        container.addView(textView)

        contadorDois ++
        if (contadorDois >= 3) {
            findViewById<Button>(R.id.bt_encerrar).visibility =
                View.VISIBLE
        }

    }

    fun encerrar(view: View){

        val tela2: Intent = Intent(
            baseContext,
            Tela2::class.java
        )

        startActivity(tela2)
    }



}