package com.example.vaialipramim.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.vaialipramim.R
import com.example.vaialipramim.dominios.Usuario
import com.example.vaialipramim.utils.AcessoSharedPreferences

class Cadastro : AppCompatActivity() {
    lateinit var  preferences: AcessoSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        preferences = AcessoSharedPreferences(this)
    }

    fun irTelaConfirmacaoEmail()
    {
        val TelaEmail= Intent(this, TelaEmail::class.java)
        startActivity(TelaEmail);
    }


    fun cadastrar(view: View) {

        val inpNomeCompleto = findViewById<EditText>(R.id.inp_nome).text.toString()
        val inpDataNascimento = findViewById<EditText>(R.id.inp_data).text.toString()
        val inpCPF = findViewById<EditText>(R.id.inp_cpf).text.toString()
        val inpEmail = findViewById<EditText>(R.id.inp_email).text.toString()
        val inpSenha = findViewById<EditText>(R.id.inp_senha).text.toString()
        val inpConfirmacaoSenha = findViewById<EditText>(R.id.inp_confSenha).text.toString()
        val inpTelefone = findViewById<EditText>(R.id.inp_telefone).text.toString()
        val cbEhConsumidor = if(findViewById<CheckBox>(R.id.check_ent).isChecked)  0 else 1

        val usuario: Usuario = Usuario(inpNomeCompleto, inpCPF,inpDataNascimento,
            inpEmail,inpSenha, inpTelefone,cbEhConsumidor
        );

        usuario.converterDatanascimento()

        if(inpSenha == inpConfirmacaoSenha && inpSenha != ""){
            preferences.SalvarUsuario("usuario",usuario)
            irTelaConfirmacaoEmail()
        }else{
            Toast.makeText(this, "Senhas não correspondem",Toast.LENGTH_SHORT ).show()
        }
    }
}