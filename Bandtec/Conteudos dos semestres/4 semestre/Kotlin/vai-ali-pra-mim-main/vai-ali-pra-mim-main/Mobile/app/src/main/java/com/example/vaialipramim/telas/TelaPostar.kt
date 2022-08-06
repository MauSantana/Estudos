package com.example.vaialipramim.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.vaialipramim.R
import com.example.vaialipramim.components.TimePickerFragment
import com.example.vaialipramim.conexoes.ConexaoIPost
import com.example.vaialipramim.dominios.Post
import com.example.vaialipramim.dominios.Usuario
import com.example.vaialipramim.utils.AcessoSharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaPostar : AppCompatActivity() {
    val IPost = ConexaoIPost.criar();
    lateinit var usuarioAnterior: Usuario;
    lateinit var preferences: AcessoSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_postar)
        preferences = AcessoSharedPreferences(this)
        usuarioAnterior = preferences.AcessarUsuario("usuario")!!
    }

    //Função que leva para tela calendário
    fun irCalendario(view: View) {

        val telaCalendario = Intent(this, Calendario::class.java)
        startActivity(telaCalendario);
    }

    //Função que leva para tela Mapa
    fun irMapa(view: View) {
        val telaMapa = Intent(this, MapsActivity::class.java)
        startActivity(telaMapa)
    }

    // Função que leva para tela Extrato
    fun irExtrato(view: View) {
        val telaExtrato = Intent(this, Extrato::class.java)
        startActivity(telaExtrato)
    }

    //Função que leva para tela PrincipalEntregador
    fun voltarTelaPrincipalEntregador() {
        val irSolicitante = Intent(this, PrincipalEntregador::class.java)
        startActivity(irSolicitante);
    }

    fun postar(view: View) {

        val nome_estabelecimento = findViewById<TextView>(R.id.nome_estabelecimento).text.toString()
        val qtd_alimentos = findViewById<TextView>(R.id.qtd_alimentos).text.toString().toInt()
        val peso_alimentos = findViewById<TextView>(R.id.peso_alimentos).text.toString().toDouble()
        val tempo_estimado = findViewById<TextView>(R.id.tv_tempo_estimado).text.toString()
        val taxa_entrega = findViewById<TextView>(R.id.et_taxa_entrega).text.toString().toDouble()

        val dataPost = preferences.AcessarValor("dataPost")
        val post = Post()

        post.entregadorId = usuarioAnterior.idUsuario
        post.titulo = nome_estabelecimento
        post.taxaEntrega = taxa_entrega;
        post.limitePesoEntrega = peso_alimentos
        post.limiteQuantidadeItens = qtd_alimentos
        post.dataHoraRealizacao = dataPost
        post.descricao =
            "Indo ao ${nome_estabelecimento} e posso buscar no máximo ${peso_alimentos}kg(s) ou ${qtd_alimentos} item(ns)";
        post.localTarefa = nome_estabelecimento
        post.tempoEstimadoRealizacao = tempo_estimado

        println("Post a ser enviado")
        println(post)

        IPost.criarPost(post).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                print(response)
                if (response.code() == 200 || response.code() == 201) {
                    Toast.makeText(
                        baseContext,
                        "Post criado com sucesso",
                        Toast.LENGTH_SHORT
                    ).show()
                    voltarTelaPrincipalEntregador()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                println(t.toString())

                Toast.makeText(
                    baseContext,
                    "Infelizmente, não foi possivel trazer posts do entregadores proximos. Tente novamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    fun irParaMenu(view: View) {
        val irParaMenu = Intent(this, TelaMenu::class.java)
        startActivity(irParaMenu);
    }

    fun showTimePickerDialog(v: View) {
        val timePicker = TimePickerFragment();
        timePicker.configurarDatePicker(this)
        timePicker.show(supportFragmentManager, "timePicker")
    }
}


