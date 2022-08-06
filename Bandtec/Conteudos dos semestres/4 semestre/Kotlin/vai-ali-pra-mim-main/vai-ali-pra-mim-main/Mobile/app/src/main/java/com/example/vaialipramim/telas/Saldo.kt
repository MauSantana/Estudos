package com.example.vaialipramim.telas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
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
import java.lang.Exception
import java.time.LocalDateTime
import java.util.*


class Saldo : AppCompatActivity() {
    lateinit var preferences: AcessoSharedPreferences
    lateinit var usuarioLogado: Usuario;
    lateinit var post: Post
    val IProduto = ConexaoIProduto.criar();
    var produtoSelecionado1: String = ""
    var produtoSelecionado2: String = ""
    var produtos: ArrayList<Produto> = ArrayList();
    var modal: Modal = Modal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saldo)
        preferences = AcessoSharedPreferences(this)
        post = preferences.AcessarPost("post_clickado")!!
        usuarioLogado = preferences.AcessarUsuario("usuario")!!
        preencherValores()
        trazerProdutos()

    }

    fun preencherValores() {
        val usuarioAnterior: Usuario? = preferences.AcessarUsuario("usuario")

        val saldo = findViewById<TextView>(R.id.saldo)

            saldo.setText(usuarioAnterior!!.saldo.toString())


        val dataHoraRealizacao = findViewById<TextView>(R.id.data_hora_realizacao)
        dataHoraRealizacao.setText(post.dataHoraRealizacao)

        val ganhoRealizacao = findViewById<TextView>(R.id.ganho_realizacao)
        ganhoRealizacao.setText(post.taxaEntrega.toString())

        val qtdItens = findViewById<TextView>(R.id.qtd_itens)
        qtdItens.setText(post.limiteQuantidadeItens.toString())

        val pesoItens = findViewById<TextView>(R.id.peso_itens)
        pesoItens.setText(post.limitePesoEntrega.toString())
    }



    fun preencherSpinners(nomes: List<String>) {
        val sp_nomes_produtos = findViewById<Spinner>(R.id.sp_nomes_produtos)
        val sp_nomes_produtos2 = findViewById<Spinner>(R.id.sp_nomes_produtos2)

        sp_nomes_produtos.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            nomes
        )
        sp_nomes_produtos2.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            nomes
        )

        sp_nomes_produtos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(baseContext, "yes", Toast.LENGTH_SHORT)
                produtoSelecionado1 = nomes.get(position)
                println(nomes.get(position))
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(baseContext, "no, it not worked", Toast.LENGTH_SHORT)
            }
        }

        sp_nomes_produtos2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(baseContext, "yes", Toast.LENGTH_SHORT)
                produtoSelecionado2 = nomes.get(position)
                println(nomes.get(position))
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(baseContext, "no, it not worked", Toast.LENGTH_SHORT)
            }
        }
    }

    //Função que leva para TelaPostar
    fun voltarPostar(view: View) {
        val voltarPrincipalSolicitante = Intent(this, PrincipalSolicitante::class.java)
        startActivity(voltarPrincipalSolicitante);
    }

    fun voltarPostar() {
        finish();
        overridePendingTransition(0, 0);
        val voltarPrincipalSolicitante = Intent(this, PrincipalSolicitante::class.java)
        startActivity(voltarPrincipalSolicitante);
        overridePendingTransition(0, 0);
    }

    fun abrirMenu(view: View) {
        val irMenu = Intent(this, TelaMenu::class.java)
        startActivity(irMenu);
    }

    fun fazerSolicitacao(view: View) {
        val pedido: Pedido? = confirmarPedido()
        println("------ post-----"    )
        println(    post)
        if (pedido != null)
            modal.show(this, pedido)

    }

    fun voltarPaginaInicial(view: View) {
        val voltar = Intent(this, PrincipalSolicitante::class.java)
        startActivity(voltar)
    }

    fun trazerProdutos() {
        IProduto.trazerTodos().enqueue(object : Callback<List<Produto>> {
            override fun onResponse(call: Call<List<Produto>>, response: Response<List<Produto>>) {
                var nomeProdutos: ArrayList<String> = ArrayList();
                produtos = response.body() as ArrayList<Produto>

                nomeProdutos.add("----Selecione um item----");
                response.body()?.forEach { nomeProdutos.add(it.nomeProduto) }
                preencherSpinners(nomeProdutos)
            }

            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun confirmarPedido(): Pedido? {
        try {
            val qtdProduto1 = findViewById<EditText>(R.id.qtd_produto1).text.toString().toInt()
            val qtdProduto2 = findViewById<EditText>(R.id.qtd_produto2).text.toString().toInt()

            val produtoSelecionado1: Produto =
                produtos.filter { it.nomeProduto == produtoSelecionado1 }[0]
            val produtoSelecionado2: Produto =
                produtos.filter { it.nomeProduto == produtoSelecionado2 }[0]
            val valorTotalCompras =
                (produtoSelecionado1.valor * qtdProduto1) + (produtoSelecionado2.valor * qtdProduto2) + post.taxaEntrega!!
            val produtosIds =
                "${produtoSelecionado1.idProduto}-${qtdProduto1};${produtoSelecionado2.idProduto}-${qtdProduto2}"

            modal.configurarModal(
                produtoSelecionado1,
                qtdProduto1,
                produtoSelecionado2,
                qtdProduto2,
                post.taxaEntrega!!,
                valorTotalCompras
            )

            val pedido: Pedido =
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    Pedido(
                        0,
                        LocalDateTime.now().toString(),
                        post.taxaEntrega!!,
                        post.localTarefa!!,
                        produtosIds,
                        valorTotalCompras,
                        post.idPost!!,
                        usuarioLogado.idUsuario
                    )
                } else {
                    TODO("VERSION.SDK_INT < O")
                }

            pedido.postId =  post.idPost!!
            return pedido;
        } catch (ex: Exception) {
            println(ex)
            return null
        }
    }
}

