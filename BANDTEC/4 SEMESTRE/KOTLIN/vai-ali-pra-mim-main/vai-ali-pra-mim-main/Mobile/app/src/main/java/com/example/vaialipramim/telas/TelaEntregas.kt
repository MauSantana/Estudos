package com.example.vaialipramim.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.vaialipramim.R

class TelaEntregas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_entregas)
    }

    fun indoMenu(view: View) {
            val irMenu = Intent(this, TelaMenu::class.java)
            startActivity(irMenu);
    }
}