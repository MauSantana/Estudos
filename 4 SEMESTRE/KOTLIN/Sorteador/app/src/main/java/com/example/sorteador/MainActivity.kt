package com.example.sorteador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var saldoAtual: Double = 120.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun camposValidos(etPalpite: EditText, etAposta: EditText) : Boolean{
        if (etPalpite.text.toString().isEmpty()){
            etPalpite.error = "Valor inválido"
            return false
        }else if (etPalpite.text.toString().toInt() !in 1..6){
            etPalpite.error = "valor deve estar entre 1 e 6"
            return false
        } else if (etAposta.text.toString().isEmpty()){
            etAposta.error = "Valor invalido"
            return false
        } else if (etAposta.text.toString().toDouble()<=0.0){
            etAposta.error = "não é permitido apostar zero"
        } else if (etAposta.text.toString().toDouble() > saldoAtual){
            etAposta.error = "não aposte mais q tem"
            return false
        }
        return true

    }
    fun validarResultado(numeroSorteado: Int, palpite: Int){
//        val etPalpite: EditText = findViewById(R.id.et_palpite)
    }

    fun Sortear() : Int = (Math.random() * 6 + 1).toInt()
    fun apostar(v: View){
        val etPalpite: EditText= findViewById(R.id.et_palpite)
        val etAposta: EditText = findViewById(R.id.et_valor_aposta)
        if(camposValidos(etPalpite, etAposta)){
            val numeroSorteado = Sortear()
            validarResultado (numeroSorteado, etPalpite.text.toString().toInt())
//            Toast.makeText(baseContext, numeroSorteado.toString(), Toast.LENGTH_LONG).show()

        }
    }
}