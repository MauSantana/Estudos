package com.example.vaialipramim.telas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.vaialipramim.R
import com.example.vaialipramim.conexoes.ConexaoIPedido
import com.example.vaialipramim.conexoes.ConexaoIPost
import com.example.vaialipramim.conexoes.ConexaoIProduto
import com.example.vaialipramim.conexoes.ConexaoIUsuario
import com.example.vaialipramim.dominios.Pedido
import com.example.vaialipramim.dominios.Post
import com.example.vaialipramim.dominios.Produto
import com.example.vaialipramim.dominios.Usuario
import com.example.vaialipramim.utils.AcessoSharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime

class TelaPendentes : AppCompatActivity() {
    lateinit var preferences: AcessoSharedPreferences
    lateinit var usuarioLogado: Usuario;
    lateinit var post: Post
    lateinit var produtos: List<Produto>
    val IPedido = ConexaoIPedido.criar();
    val IUsuario = ConexaoIUsuario.criar();
    val IPost = ConexaoIPost.criar();
    val IProduto = ConexaoIProduto.criar();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_pendentes)
        preferences = AcessoSharedPreferences(this)
        post = preferences.AcessarPost("post_clickado")!!
        usuarioLogado = preferences.AcessarUsuario("usuario")!!

        preencherInfoEstaticas()
        trazerProdutos()
        produtos = preferences.AcessarProdutos("produtos")
        TrazerPedidosDoPost(post.idPost!!)
    }

    fun PreencherPedidos(pedidos: List<Pedido>) {
        if (pedidos.size == 0) {
            MostrarVazio()
            return
        }

        val llTarefasPendentes = findViewById<LinearLayout>(R.id.ll_pedidos_feitos)
        var index = 0;

        pedidos.forEach { pedido ->
            val vi: LayoutInflater =
                applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val v: View = vi.inflate(R.layout.fragment_pedido, null)

            TrazerSolicitante(pedido.solicitanteId)

            val solicitante: Usuario? = preferences.AcessarUsuario("solicitante")
            val nome_solicitante = v.findViewById<View>(R.id.tv_nome_solicitante) as TextView
            nome_solicitante.setText(solicitante?.nomeCompleto)

            println(pedido)

            val data_pedido = v.findViewById<View>(R.id.tv_data_pedido) as TextView
            val c = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                LocalDateTime.parse(pedido.dataHora)
            } else {
                TODO("VERSION.SDK_INT < O")
            }

            pedido.dataHora = "${c.dayOfMonth}/${c.monthValue}/${c.year} ${c.hour}:${c.minute}"
            data_pedido.setText( "Feito em: ${pedido.dataHora}")

            pedido.formatarProdutoQuantidade()

            for (item in pedido.produtos) {
                produtos.forEach { produto ->
                    if (produto.idProduto == item.first.idProduto) {
                        item.first.nomeProduto = produto.nomeProduto
                        item.first.valor = produto.valor
                        item.first.marca = produto.marca
                        item.first.tipoProduto = produto.tipoProduto
                    }
                }
            }

            val primeiro_item_pedido =
                v.findViewById<View>(R.id.tv_primeiro_item_pedido) as TextView
            primeiro_item_pedido.setText(
                "* ${pedido.produtos[0].second} -- ${pedido.produtos[0].first.nomeProduto}"
            )

            val preco_primeiro_item =
                v.findViewById<View>(R.id.tv_preco_primeiro_item) as TextView
            preco_primeiro_item.setText(
                "Preço: R$${pedido.produtos[0].first.valor}"
            )

            val segundo_item_pedido =
                v.findViewById<View>(R.id.tv_segundo_item_pedido) as TextView
            segundo_item_pedido.setText(
                "* ${pedido.produtos[1].second} -- ${pedido.produtos[1].first.nomeProduto}"
            )

            val preco_segundo_item =
                v.findViewById<View>(R.id.tv_preco_segundo_item) as TextView
            preco_segundo_item.setText(
                "Preço: R$${pedido.produtos[1].first.valor}"
            )

            val valor_total_compras =
                v.findViewById<View>(R.id.tv_valor_total_compras) as TextView
            valor_total_compras.setText(
                "** Preço total: R$${pedido.valorTotalCompras}"
            )

            val aceitar_pedido = v.findViewById<Button>(R.id.bt_aceitar_pedido)

            aceitar_pedido.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    aceitarPedido(pedido.idPedido)
                }
            })

            val rejeitar_pedido = v.findViewById<Button>(R.id.bt_rejeitar_pedido)

            rejeitar_pedido.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    rejeitarPedido(pedido.idPedido)
                }
            })

            llTarefasPendentes.addView(
                v,
                index++,
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.FILL_PARENT
                )
            )
        }
    }

    private fun MostrarVazio() {
        println("vazio")
    }

    fun preencherInfoEstaticas() {
        val local_entrega = findViewById<TextView>(R.id.tv_local_entrega)
        local_entrega.setText("${post.titulo}- ${post.localTarefa}")

        val dataHora = findViewById<TextView>(R.id.tv_datahora)
        dataHora.setText(post.dataHoraRealizacao)

        val ganho_entrega = findViewById<TextView>(R.id.tv_ganho_entrega)
        ganho_entrega.setText("${post.taxaEntrega} R$")

        val qtd_itens = findViewById<TextView>(R.id.tv_qtd_itens)
        qtd_itens.setText(post.limiteQuantidadeItens.toString())

        val qtd_kilo = findViewById<TextView>(R.id.tv_qtd_kilo)
        qtd_kilo.setText("${post.limitePesoEntrega} kg(s)")

        val tempo_estimado = findViewById<TextView>(R.id.tv_tempo_estimado)
        tempo_estimado.setText("${post.tempoEstimadoRealizacao}")

    }

    fun voltarPrincipalEntregador(view: View) {
        voltarPrincipalEntregador()
    }

    fun voltarPrincipalEntregador() {
        val voltar = Intent(this, PrincipalEntregador::class.java)
        startActivity(voltar)
    }

    fun abrirMenu(view: View) {
        val irMenu = Intent(this, TelaMenu::class.java)
        startActivity(irMenu);
    }

    fun apagarPost(view: View) {
        IPost.deletarPost(post.idPost!!).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        baseContext,
                        "Post apagado com sucesso",
                        Toast.LENGTH_SHORT
                    ).show()
                    voltarPrincipalEntregador()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(
                    baseContext,
                    "Infelizmente, não foi possivel trazer pedidos do post. Tente novamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
    private fun TrazerSolicitante(solicitanteId: Int) {
        IUsuario.trazerUmUsuario(solicitanteId).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful) {
                    preferences.SalvarUsuario("solicitante", response.body()!!)

                }
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                println(t.toString())
                Toast.makeText(
                    baseContext,
                    "Infelizmente, não foi possivel trazer dados do solicitante. Tente novamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    fun TrazerPedidosDoPost(idPost: Int) {
        IPedido.trazerPedidosAbertosDeUmPost(idPost).enqueue(object : Callback<List<Pedido>> {
            override fun onResponse(call: Call<List<Pedido>>, response: Response<List<Pedido>>) {
                println("call")
                println(call)
                println("response")
                println(response)
                if (response.isSuccessful && response.body() != null)
                    PreencherPedidos(response.body()!!)
                else {
                    MostrarVazio()
                }
            }

            override fun onFailure(call: Call<List<Pedido>>, t: Throwable) {
                println(t.toString())
                Toast.makeText(
                    baseContext,
                    "Infelizmente, não foi possivel trazer pedidos do post. Tente novamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
    fun trazerProdutos() {
        IProduto.trazerTodos().enqueue(object : Callback<List<Produto>> {
            override fun onResponse(call: Call<List<Produto>>, response: Response<List<Produto>>) {
                if (response.isSuccessful)
                    preferences.SalvarProdutos("produtos", response.body())
            }

            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                Toast.makeText(
                    baseContext,
                    "Infelizmente, não foi possivel trazer dados dos produtos. Tente novamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
    private fun aceitarPedido(idPedido: Int) {
        IPedido.aceitarPedido(idPedido).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        baseContext,
                        "Pedido aceito com sucesso",
                        Toast.LENGTH_SHORT
                    ).show()
                    voltarPrincipalEntregador()

                } else {
                    Toast.makeText(
                        baseContext,
                        "Não foi possível aceitar Pedido",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                println(t.toString())
                Toast.makeText(
                    baseContext,
                    "Infelizmente, não foi possível aceitar Pedido. Tente novamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun rejeitarPedido(idPedido: Int) {
        IPedido.rejeitarPedido(idPedido).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        baseContext,
                        "Pedido recusado com sucesso",
                        Toast.LENGTH_SHORT
                    ).show()
                    voltarPrincipalEntregador()

                } else {
                    Toast.makeText(
                        baseContext,
                        "Não foi possível recusar Pedido",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                println(t.toString())
                Toast.makeText(
                    baseContext,
                    "Infelizmente, não foi possível recusar Pedido. Tente novamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}