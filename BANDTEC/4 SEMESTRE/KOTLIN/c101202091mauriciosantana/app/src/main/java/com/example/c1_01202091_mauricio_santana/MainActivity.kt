package com.example.c1_01202091_mauricio_santana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.marginTop

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.bt_Novo).visibility =
            View.GONE
        findViewById<Button>(R.id.bt_Apurar).visibility =
            View.VISIBLE
    }

    fun camposValidos(
        et_votosPrimeiroCandidato: EditText,
        et_votosSegundoCandidato: EditText,
        et_nomePrimeiroCandidato: EditText,
        et_nomeSegundoCandidato: EditText
    ): Boolean {
        if (et_votosPrimeiroCandidato.text.toString().isEmpty()) {
            et_votosPrimeiroCandidato.error = "Valor inválido !"
            return false
        } else if (et_votosSegundoCandidato.text.toString().isEmpty()) {
            et_votosSegundoCandidato.error = "Valor inválido !"
            return false
        } else if (et_votosSegundoCandidato.text.toString().toDouble() <= 0 ) {
            et_votosSegundoCandidato.error = "Valor inválido !"
            return false
        } else if (et_votosPrimeiroCandidato.text.toString().toDouble() <= 0 ) {
            et_votosPrimeiroCandidato.error = "Valor inválido !"
            return false
        } else if (et_votosPrimeiroCandidato === et_votosSegundoCandidato) {
            et_votosPrimeiroCandidato.error = "Valor inválido !"
            return false
        } else if (et_nomeSegundoCandidato.text.toString().isEmpty()) {
            et_nomeSegundoCandidato.error = "Valor inválido !"
            return false
        }
        else if (et_nomePrimeiroCandidato.text.toString().isEmpty()) {
            et_nomePrimeiroCandidato.error = "Valor inválido !"
            return false
        }
        return true
}

    fun calcularVotacao(){
        val btApuracao: Button = findViewById(R.id.bt_Apurar)
        val resultVotacao: TextView = findViewById(R.id.tv_resultadoVotacao)   // Não tinha declarado o tipo(TextView) na prova
        resultVotacao.text.toString()
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

            findViewById<TextView>(R.id.tv_resultadoVotacao).text =
                "$primeiroNome venceu com %$porcVotosPrimeiroCandidato dos votos"

            resultVotacao.setTextColor(
                AppCompatResources.getColorStateList(
                    baseContext,
                    R.color.red
                )
            )
        } else {
            findViewById<TextView>(R.id.tv_resultadoVotacao).text =
                "$segundoNome venceu com %$porcVotosSegundoCandidato dos votos"
            resultVotacao.setTextColor(
                AppCompatResources.getColorStateList(
                    baseContext,
                    R.color.purple
                )
            )
        }
    }

    fun votar(v: View) {

        val primeiroCandidato = findViewById<EditText>(R.id.et_votosPrimeiroCandidato)
        val segundoCandidato = findViewById<EditText>(R.id.et_votosSegundoCandidato)
        val nomeSegundoCandidato = findViewById<EditText>(R.id.et_nomeSegundoCandidato)
        val nomePrimeiroCandidato = findViewById<EditText>(R.id.et_nomePrimeiroCandidato)

        if (camposValidos(primeiroCandidato, segundoCandidato,nomeSegundoCandidato,nomePrimeiroCandidato )) {
           calcularVotacao()

            findViewById<Button>(R.id.bt_Novo).visibility =
                View.VISIBLE
            findViewById<Button>(R.id.bt_Apurar).visibility =
                View.GONE
        }
    }

    fun novaVotacao(v: View) {
        val resultVotacao: TextView = findViewById(R.id.tv_resultadoVotacao)
        resultVotacao.text.toString()

        findViewById<TextView>(R.id.tv_resultadoVotacao).text =
            ""
        findViewById<TextView>(R.id.et_votosPrimeiroCandidato).text =
            ""
        findViewById<TextView>(R.id.et_votosSegundoCandidato).text =
            ""
        findViewById<TextView>(R.id.et_nomeSegundoCandidato).text =
            ""
        findViewById<TextView>(R.id.et_nomePrimeiroCandidato).text =
            ""
        findViewById<Button>(R.id.bt_Novo).visibility =
            View.GONE
        findViewById<Button>(R.id.bt_Apurar).visibility =
            View.VISIBLE

    }
}