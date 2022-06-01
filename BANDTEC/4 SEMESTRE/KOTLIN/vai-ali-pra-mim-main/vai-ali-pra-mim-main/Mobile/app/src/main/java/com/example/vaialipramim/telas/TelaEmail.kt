package com.example.vaialipramim.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.vaialipramim.R
import com.example.vaialipramim.conexoes.ConexaoToken
import com.example.vaialipramim.dominios.Token
import com.example.vaialipramim.dominios.Usuario
import com.example.vaialipramim.utils.AcessoSharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaEmail : AppCompatActivity() {
    lateinit var  preferences: AcessoSharedPreferences
    val IToken = ConexaoToken.criar()

    lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_email)
        preferences = AcessoSharedPreferences(this)
        usuario = preferences.AcessarUsuario("usuario")!!

        val msgConf = findViewById<TextView>(R.id.tv_msgConfirmacaoEmail)
        msgConf.setText("Foi enviado um código de verificação para: ${usuario.email}")

        IToken.criarToken(Token(usuario.email)).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.code() == 200 || response.code() == 201)
                    Toast.makeText(baseContext, "Código enviado com sucesso", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext, "Não foi possível enviar código. Tente novamente", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun irTelaDeTermos(){
        val telaCondicoes = Intent(this, TelaTC::class.java)
        startActivity(telaCondicoes);
    }

    fun confirmarCodigo(view: View) {
        val codigoVerificacao = findViewById<TextView>(R.id.ed_codigoVerificacao).text.toString()
        val token: Token = Token(usuario.email, codigoVerificacao)
        println(usuario)

        IToken.verificarToken(token).enqueue(object : Callback<Void> {

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.code() == 200 || response.code() == 201){
                    Toast.makeText(baseContext, "Código validado", Toast.LENGTH_SHORT).show()
                    irTelaDeTermos()
                }else{
                    println(response)
                    Toast.makeText(baseContext, "Código Inválido. Tente novamente", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext, "Código Inválido. Tente novamente", Toast.LENGTH_SHORT).show()
            }
        })
    }
}