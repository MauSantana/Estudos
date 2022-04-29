package com.example.exercicio30_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var container: LinearLayout
    private var total: Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        container = findViewById(R.id.layout_container)
    }

    fun adicionarFruta(view: View) {
        val textView = TextView(baseContext)
        textView.text = getString(R.string.mensagem_fruta)
        textView.setTextColor(getColor(R.color.azul))
        container.addView(textView)
        total += 10.00
        comprar()
    }
    fun adicionarLegume(view: View) {
        val textView = TextView(baseContext)
        textView.text = getString(R.string.mensagem_legume)
        textView.setTextColor(getColor(R.color.vermelho))
        container.addView(textView)
        total += 20.00
        comprar()
    }

    fun comprar() {
        val textView = TextView(baseContext)
        textView.text = getString(R.string.mensagem_com_parametro, total)
        textView.setTextColor(getColor(R.color.verde))
        container.addView(textView)

    }

    fun limparMensagem(view: View) {
        container.removeAllViews()
        total = 0.00
    }
}