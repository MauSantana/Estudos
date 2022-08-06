package com.example.vaialipramim.telas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vaialipramim.R
import com.example.vaialipramim.conexoes.ConexaoIUsuario
import com.example.vaialipramim.dominios.Usuario
import com.example.vaialipramim.dominios.UsuarioLogin
import com.example.vaialipramim.utils.AcessoSharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import kotlin.Exception


class TelaLogin : AppCompatActivity() {
    val Iusuario = ConexaoIUsuario.criar();
    lateinit var preferences: AcessoSharedPreferences

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)
        preferences = AcessoSharedPreferences(this)
        val usuarioAnterior: Usuario? = preferences.AcessarUsuario("usuario")

        if (usuarioAnterior != null) {
            redirecionarUsuarioParaDashboardEspecifico(usuarioAnterior.ehConsumidor)
        }

    }

    fun redirecionarUsuarioParaDashboardEspecifico(ehConsumidor: Int) {
        var dashboard: Intent;

        if (ehConsumidor == 1) {
            dashboard = Intent(this, PrincipalSolicitante::class.java)
        } else if (ehConsumidor == 0) {
            dashboard = Intent(this, PrincipalEntregador::class.java)
        } else {
            Log.e("this", "nem entregador nem solicitante")
            return;
        }

        startActivity(dashboard);
    }

    fun logar(view: View) {
        val edEmail = findViewById<EditText>(R.id.ed_email).text.toString()
        val edSenha = findViewById<EditText>(R.id.ed_senha).text.toString()
        try {

            println("Click")
            Iusuario.login(UsuarioLogin(edEmail, edSenha)).enqueue(object : Callback<Usuario> {

                override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                    println("onRes")
                    if (response.code() == 404) {
                        Toast.makeText(
                            baseContext,
                            "Usuário não encontrado. Tente novamente",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else if (response.code() == 200) {

                        if (response.body() != null) {
                            preferences.SalvarUsuario("usuario", response.body()!!)
                            redirecionarUsuarioParaDashboardEspecifico(response.body()!!.ehConsumidor)
                        }
                    } else
                        println(response)
                }

                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    println("onFailure")
                    Log.e("api", t.message!!)
                    Log.e(
                        "-----",
                        "------------------------------------------------------------------------------------------------------------------------------------------"
                    )
                    Toast.makeText(baseContext, "404", Toast.LENGTH_SHORT).show()
                }
            })
        } catch (E: Exception) {
            println("erro")
            println(E)
        }
        println("final")
    }

    fun esqueciSenha(view: View) {
        val esqueciSenha = Intent(this, EsqueceuSenha::class.java)
        startActivity(esqueciSenha)
    }

}