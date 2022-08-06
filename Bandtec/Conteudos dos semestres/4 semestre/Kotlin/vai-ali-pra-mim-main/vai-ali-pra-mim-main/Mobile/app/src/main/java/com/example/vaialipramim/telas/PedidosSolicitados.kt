package com.example.vaialipramim.telas

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.vaialipramim.R
import com.example.vaialipramim.components.Modal
import com.example.vaialipramim.conexoes.ConexaoIProduto
import com.example.vaialipramim.dominios.Pedido
import com.example.vaialipramim.dominios.Post
import com.example.vaialipramim.dominios.Produto
import com.example.vaialipramim.dominios.Usuario
import com.example.vaialipramim.utils.AcessoSharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime

class PedidosSolicitados : AppCompatActivity() {
    lateinit var preferences: AcessoSharedPreferences
    var modal: Modal = Modal()
    val IProduto = ConexaoIProduto.criar();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos_solicitados)
        preferences = AcessoSharedPreferences(this)
        trazerProdutos()

    }

    fun indoMenu(view: View) {
        val irMenu = Intent(this, TelaMenu::class.java)
        startActivity(irMenu);
    }

    fun voltarPaginaInicial(view: View) {
        val principalSolicitante = Intent(this, PrincipalSolicitante::class.java)
        startActivity(principalSolicitante);
    }

    @SuppressLint("ResourceAsColor")
    fun definirMensagemDeStatus(pedido: Pedido?, foiAceito: Int, v: View) {
        val statusPost = v.findViewById<TextView>(R.id.tv_status_post)

        if (foiAceito == 1) {
            statusPost.setText(R.string.solicitacão_aceita)
            statusPost.setTextColor(getColor(R.color.verde))
        } else if (foiAceito == 0) {
            statusPost.setText(R.string.solicitacão_recusada)
            statusPost.setTextColor(getColor(R.color.vermelho))
        } else if (foiAceito == 2) {
            statusPost.setText(R.string.solicitação_esperando_resposta)
            statusPost.setTextColor(getColor(R.color.prata))
        }
    }

    fun preecherTarefasPendentes(produtos: List<Produto>) {
        val pedidosDoUsuario: List<Pedido> = preferences.AcessarPedidos("pedidosDoUsuario")

        val llPedidosSolicitados = findViewById<LinearLayout>(R.id.ll_pedidos_solicitados)
        var posts: List<Post> = preferences.AcessarPosts("posts")
        var entregadoresProximos: List<Usuario> =
            preferences.AcessarEntregadores("entregadoresProximos")
        var index = 1

        if (posts.size == 0) {
            val textView = findViewById<TextView>(R.id.tv_header_tarefas_proximas)
            textView.setText(R.string.nao_entregadores_proximos)
            textView.height = 100
        } else {
            posts.forEach { post ->
                var pedidoParaEssePost: Pedido? = null
                val vi: LayoutInflater =
                    applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val v: View = vi.inflate(R.layout.component_post, null)

                pedidosDoUsuario.forEach { pedido ->

                    if (pedido.postId == post.idPost) {
                        pedidoParaEssePost = pedido

                        if (pedido.foiAceito == 2)
                            definirMensagemDeStatus(pedidoParaEssePost, 3, v)
                        else
                            definirMensagemDeStatus(pedidoParaEssePost, pedido.foiAceito, v)
                    }
                }

                val entregadorDoPost = entregadoresProximos.filter { itEntregadores ->
                    itEntregadores.idUsuario == post.entregadorId
                }[0]

                val textView = v.findViewById<View>(R.id.nome_entregador) as TextView
                if (entregadorDoPost.nomeCompleto.length > 15)
                    textView.text = entregadorDoPost.nomeCompleto.removeRange(
                        13,
                        entregadorDoPost.nomeCompleto.length
                    ) + "..."
                else
                    textView.text = entregadorDoPost.nomeCompleto

                val datahora = v.findViewById<View>(R.id.data_hora_tarefa) as TextView
                val c = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    LocalDateTime.parse(post.dataHoraRealizacao)
                } else {
                    TODO("VERSION.SDK_INT < O")
                }

                post.dataHoraRealizacao = "${c.dayOfMonth}/${c.monthValue} ${c.hour}:${
                    c.minute.toString().padStart(2, '0')
                }"
                datahora.text = post.dataHoraRealizacao

                val localTarefa = v.findViewById<View>(R.id.local_tarefa) as TextView
                localTarefa.text = post.localTarefa

                if (pedidoParaEssePost != null) {
                    definirMensagemDeStatus(pedidoParaEssePost, pedidoParaEssePost!!.foiAceito, v)

                    v.setOnClickListener(object : View.OnClickListener {
                        override fun onClick(v: View?) {
                            println("kilometres")
                            modal.showModalPedido(this@PedidosSolicitados, pedidoParaEssePost!!, produtos)
                        }
                    })

                    llPedidosSolicitados.addView(
                        v,
                        index++,
                        ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.FILL_PARENT,
                            ViewGroup.LayoutParams.FILL_PARENT
                        )
                    )
                }
            }
        }
    }

    fun trazerProdutos() {
        IProduto.trazerTodos().enqueue(object : Callback<List<Produto>> {
            override fun onResponse(call: Call<List<Produto>>, response: Response<List<Produto>>) {

                preecherTarefasPendentes(response.body()!!)
            }

            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}