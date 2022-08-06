package com.example.vaialipramim.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.example.vaialipramim.R

class Extrato : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extrato)
    }

    fun irParaEntregadores(view: View) {
        val irEntregador = Intent(this, EntregadoresFavoritos::class.java)
        startActivity(irEntregador);
    }

    fun voltarPostar(view: View) {

        val voltarPostar = Intent(this, TelaPostar::class.java)
        startActivity(voltarPostar);
    }

    fun irParaMenu(view: View) {
        val irMenu = Intent(this, TelaMenu::class.java)
        startActivity(irMenu);
    }
}