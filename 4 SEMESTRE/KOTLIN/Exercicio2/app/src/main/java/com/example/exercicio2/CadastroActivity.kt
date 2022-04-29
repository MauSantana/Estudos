package com.example.exercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
    }

    fun camposValidos(
        et_email: EditText,
        et_password: EditText,
        et_confirme_password: EditText
    ): Boolean {
        if (et_email.text.toString().isEmpty()) {
            et_email.error = "Valor inválido !"
            return false
        } else if (et_password.text.toString().isEmpty()) {
            et_password.error = "Valor inválido !"
            return false
        } else if (et_confirme_password.text.toString().isEmpty()) {
        et_confirme_password.error = "Valor inválido !"
            return false
        }
        return true
    }

    fun cadastrar(v: View) {
        val email = findViewById<EditText>(R.id.et_email)
        val senha = findViewById<EditText>(R.id.et_password)
        val confirmarSenha = findViewById<EditText>(R.id.et_confirme_password)

        camposValidos(email, senha, confirmarSenha);
    }
}