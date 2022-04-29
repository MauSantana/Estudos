package com.example.exercicio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun camposValidos(
        et_email: EditText,
        et_password: EditText
    ): Boolean {
        if (et_email.text.toString() !== "admin@admin.com" && et_password.text.toString() !== "12345") {
            et_email.error = "Valor inválido !"
            et_password.error = "Valor inválido !"
            return false
        } else {

        }
        return true
    }

    fun entrar(v: View) {

        val email = findViewById<EditText>(R.id.et_email)
        val password = findViewById<EditText>(R.id.et_password)
        if (camposValidos(email, password)) {
            "boa"
        }
    }

    fun cadastrar(view: View){

        val tela2: Intent = Intent(
            baseContext,
            CadastroActivity::class.java
        )
        startActivity(tela2)


    }

}