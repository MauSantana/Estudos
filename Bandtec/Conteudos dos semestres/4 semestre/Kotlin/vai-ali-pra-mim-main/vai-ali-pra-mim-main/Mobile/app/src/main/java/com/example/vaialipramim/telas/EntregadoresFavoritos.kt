package com.example.vaialipramim.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.vaialipramim.R

class EntregadoresFavoritos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entregadores_favoritos)
    }

    fun voltarExtrato(view: View) {
        val irExtrato = Intent(this, Extrato::class.java)
        startActivity(irExtrato);
    }
}