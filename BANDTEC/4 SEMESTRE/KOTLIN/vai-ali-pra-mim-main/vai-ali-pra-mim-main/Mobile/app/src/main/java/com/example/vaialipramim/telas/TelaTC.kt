package com.example.vaialipramim.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.example.vaialipramim.R
import com.example.vaialipramim.conexoes.ConexaoIUsuario
import com.example.vaialipramim.dominios.Usuario
import com.example.vaialipramim.utils.AcessoSharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaTC : AppCompatActivity() {
    lateinit var preferences: AcessoSharedPreferences
    val IUsuario = ConexaoIUsuario.criar()
    lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_t_c)
        preferences = AcessoSharedPreferences(this)
        usuario = preferences.AcessarUsuario("usuario")!!
        println(usuario)
    }

    fun redirecionarUsuarioParaDashboardEspecifico(ehConsumidor: Int) {
        if (ehConsumidor == 1) {
            IrTelaPrincipalSolicitante();
            println("PrincipalSolicitante")

        } else if (ehConsumidor == 0) {
            IrTelaPrincipalEntregador()
            println("PrincipalEntregador")
        } else {
            println("nem Entregador nem Solicitante")
        }
    }

    fun IrTelaPrincipalSolicitante() {
        val principalSolicitante = Intent(this, PrincipalSolicitante::class.java)
        startActivity(principalSolicitante);
    }

    fun IrTelaPrincipalEntregador() {
        val principalEntregador = Intent(this, PrincipalEntregador::class.java)
        startActivity(principalEntregador);
    }

    fun redirecionarParaDashboard(view: View) {
        val cb_aceite_termos: Boolean = findViewById<CheckBox>(R.id.cb_aceite_termos).isChecked
            println(cb_aceite_termos)
        if (cb_aceite_termos){
            criarUsuario()

        }else{
            Toast.makeText(baseContext, "Você precisa concordar com os termos e condições", Toast.LENGTH_SHORT).show()
        }
    }

    fun criarUsuario(){
        IUsuario.criar(usuario).enqueue(object :
            Callback<Void> {

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.code() == 200 || response.code() == 201){
                    redirecionarUsuarioParaDashboardEspecifico(usuario.ehConsumidor)
                }else{
                    println("Não foi possivel criar usuario")
                    println(response.code())
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                println(t.message)
                Toast.makeText(baseContext, "Infelizmente, não foi possivel criar usuario. Tente novamente", Toast.LENGTH_SHORT).show()
            }
        })
    }
}