package com.example.vaialipramim.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import com.example.vaialipramim.R

class Transacoes : AppCompatActivity() {

    //definindo o Spinner
    lateinit var mes: Spinner;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transacoes)
        mes = findViewById(R.id.mesSelecionado)
        mes.onItemSelectedListener;


    }


    //Função que leva para Tela PrincipalSolicitante
    fun voltarPrincipalSolicitante(view: View) {
        val voltarPrincipal = Intent(this, PrincipalSolicitante::class.java)
        startActivity(voltarPrincipal)

    }

    //Função que leva a Tela de Saldo
    fun irSaldo(view: View) {
        val irSaldo = Intent(this, Saldo::class.java)
        startActivity(irSaldo)
    }


}