package com.example.vaialipramim.telas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.vaialipramim.R
import com.example.vaialipramim.conexoes.ConexaoIPedido
import com.example.vaialipramim.conexoes.ConexaoIPost
import com.example.vaialipramim.dominios.Post
import com.example.vaialipramim.dominios.Usuario
import com.example.vaialipramim.utils.AcessoSharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.time.LocalDateTime

class PrincipalEntregador : AppCompatActivity() {

    lateinit var preferences: AcessoSharedPreferences
   lateinit var usuarioAnterior: Usuario;
    val IPost = ConexaoIPost.criar();
    val IPedido = ConexaoIPedido.criar();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_entregador)

        preferences = AcessoSharedPreferences(this)
        usuarioAnterior = preferences.AcessarUsuario("usuario")!!

        val tvNomeSolicitante = findViewById<TextView>(R.id.vt_nomeEntregador)
       tvNomeSolicitante.setText(usuarioAnterior.nomeCompleto.split(' ')[0])

        val tvSaldo = findViewById<TextView>(R.id.vt_saldo)
        tvSaldo.setText(usuarioAnterior.saldo.toString())

       trazerPosts(usuarioAnterior.idUsuario.toString())
//        trazerPedidosFeitosPorUsuario(usuarioAnterior.idUsuario)

    }

    fun trazerPosts(arrayIds: String) {
        IPost.trazerPostsDeAlgunsUsuarios(arrayIds).enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                preferences.SalvarPosts("posts", response.body())
                response.body()!!.forEach {
                    println(it)
                }

                preecherTarefasPendentes()
            }


            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                println(t.toString())
                Toast.makeText(
                    baseContext,
                    "Infelizmente, não foi possivel trazer posts do entregadores proximos. Tente novamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    fun mudarAlturaBalde(v: View) {
        // try {
        val linearLayoutBalde = v.findViewById<LinearLayout>(R.id.ll_balde_post)
        val layoutParams = linearLayoutBalde.layoutParams
        layoutParams.height = 320

        // }catch(e:Exception){
        //    Toast.makeText(baseContext, "Erro: mudarAlturaBalde", Toast.LENGTH_SHORT).show()
        // }
    }


    fun preecherTarefasPendentes() {
        val llTarefasPendentes = findViewById<LinearLayout>(R.id.llTarefas_pendentes)
        var posts: List<Post> = ArrayList<Post>();

        try {
            posts = preferences.AcessarPosts("posts")

        } catch (exc: Exception) {
            println(exc.message)
        }

        var index = 1

        if (posts.size == 0) {
            val textView = findViewById<TextView>(R.id.tv_header_entregas_pendentes)
            textView.setText(R.string.nao_ha_tarefas_pendentes)
            textView.height = 150
        } else {
            Log.d("criandoLista", "criandoLista ${System.currentTimeMillis()}")
            posts.forEach {
                val vi:LayoutInflater =
                    applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val v: View = vi.inflate(R.layout.component_post, null)


                val textView = v.findViewById<View>(R.id.nome_entregador) as TextView
                if (usuarioAnterior.nomeCompleto.length > 15)
                    textView.text = usuarioAnterior.nomeCompleto.removeRange(
                        13,
                        usuarioAnterior.nomeCompleto.length
                    ) + "..."
                else
                    textView.text = usuarioAnterior.nomeCompleto

                val datahora = v.findViewById<View>(R.id.data_hora_tarefa) as TextView
                val c = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    LocalDateTime.parse(it.dataHoraRealizacao)
                } else {
                    TODO("VERSION.SDK_INT < O")
                }
                it.dataHoraRealizacao = "${c.dayOfMonth}/${c.monthValue} ${c.hour}:${c.minute}"
                datahora.text = it.dataHoraRealizacao

                val localTarefa = v.findViewById<View>(R.id.local_tarefa) as TextView
                localTarefa.text = it.localTarefa

                v.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        preferences.SalvarPost("post_clickado", it)
                        abrirTarefaPost()
                    }
                })
                mudarAlturaBalde(v)
                llTarefasPendentes.addView(
                    v,
                    index++,
                    ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT,
                        ViewGroup.LayoutParams.FILL_PARENT
                    )
                )

                println("IdPost: ${it.idPost}")
               // if (pedidos.contains(it.idPost.toString()))
                //    mudarAlturaBalde()

            }
        }
    }

    fun irParaMenu(view: View) {
        val indoParaMenu = Intent(this,TelaMenu::class.java)
        startActivity(indoParaMenu)
    }
    fun irTransacoes(view: View) {
        val irTransacoes = Intent(this, Transacoes::class.java)
        startActivity(irTransacoes);
    }

    fun abrirTarefaPost() {
        val telaPost = Intent(this, TelaPendentes::class.java)
        startActivity(telaPost);
    }


    fun clickMenu(view: View) {
        val irMenu = Intent(this, TelaMenu::class.java)
        startActivity(irMenu);

    }

    fun FazerNovoPost(view: View) {
        val telaPostar = Intent(this, TelaPostar::class.java)
        startActivity(telaPostar);

    }


}