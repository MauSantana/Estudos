package com.example.aula_30_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var container: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        container = findViewById(R.id.layout_container)
    }

    fun adicionarMensagem(view: View) {
        val textView = TextView(baseContext)
        textView.text = getString(R.string.mensagem_com_parametros, "mau", 20)
        container.addView(textView)
    }
    fun limparMensagem(view: View) {
        container.removeAllViews()
    }
}