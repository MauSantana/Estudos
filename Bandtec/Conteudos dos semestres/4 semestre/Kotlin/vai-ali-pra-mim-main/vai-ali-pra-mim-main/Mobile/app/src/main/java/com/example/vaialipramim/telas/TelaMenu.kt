package com.example.vaialipramim.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.vaialipramim.R
import com.example.vaialipramim.dominios.Usuario
import com.example.vaialipramim.utils.AcessoSharedPreferences

class TelaMenu : AppCompatActivity() {
    lateinit var preferences: AcessoSharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_menu)
        preferences = AcessoSharedPreferences(this)


    }

    fun paginaAnterior(view: View) {
        super.onBackPressed();
    }

    fun paginaHome(view: View) {
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


    fun paginaEditarPerfil(view: View) {
        val paginaEditarPerfil = Intent(this,EditarPerfil::class.java)
        startActivity(paginaEditarPerfil);
    }

    fun configuracoes(view: View) {}

    fun faq(view: View) {}

    fun nosAvalie(view: View) {}

    fun sair(view: View) {
        preferences.ResetarPreferences()
        val paginaLogin = Intent(this,TelaInicial::class.java)
        startActivity(paginaLogin);
    }

    fun voltarPaginaAnterior(view: View) {
        super.onBackPressed();
    }
}