package com.example.c1_01202091_mauricio_santana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun camposValidos(
        et_votosPrimeiroCandidato: EditText,
        et_votosSegundoCandidato: EditText
    ): Boolean {
        if (et_votosPrimeiroCandidato.text.toString().isEmpty()) {
            et_votosPrimeiroCandidato.error = "Valor inválido !"
            return false
        } else if (et_votosSegundoCandidato.text.toString().isEmpty()) {
            et_votosSegundoCandidato.error = "Valor inválido !"
            return false
        }
        return true
    }

    fun calcularVotacao(){
        val resultVotacao = findViewById<TextView>(R.id.tv_resultadoVotacao)
            .text.toString()
        val primeiroNome = findViewById<EditText>(R.id.et_nomePrimeiroCandidato)
            .text.toString()
        val segundoNome = findViewById<EditText>(R.id.et_nomeSegundoCandidato)
            .text.toString()
        val totalVotosPrimeiroCandidato = findViewById<EditText>(R.id.et_votosPrimeiroCandidato)
            .text.toString().toDouble()
        val totalVotosSegundoCandidato = findViewById<EditText>(R.id.et_votosSegundoCandidato)
            .text.toString().toDouble()
        val totalVotos = totalVotosPrimeiroCandidato + totalVotosSegundoCandidato
        val porcVotosPrimeiroCandidato = (totalVotosPrimeiroCandidato / totalVotos) * 100
        val porcVotosSegundoCandidato = (totalVotosSegundoCandidato / totalVotos) * 100

        if (porcVotosPrimeiroCandidato > porcVotosSegundoCandidato) {
//            resultVotacao.setTextColor(
//                AppCompatResources.getColorStateList(
//                    baseContext,
//                    R.color.purple
//                )
//            )
            findViewById<TextView>(R.id.tv_resultadoVotacao).text =
                "$primeiroNome+ venceu com % +$porcVotosPrimeiroCandidato"
        } else {
            findViewById<TextView>(R.id.tv_resultadoVotacao).text =
                "$segundoNome+ venceu com % +$porcVotosSegundoCandidato"
        }


    }

    fun votar(v: View) {

        val primeiroCandidato = findViewById<EditText>(R.id.et_votosPrimeiroCandidato)
        val segundoCandidato = findViewById<EditText>(R.id.et_votosSegundoCandidato)
        if (camposValidos(primeiroCandidato, segundoCandidato)) {
            calcularVotacao()
        }
    }
}