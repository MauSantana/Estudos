package com.example.vaialipramim.telas

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.vaialipramim.R
import com.example.vaialipramim.conexoes.ConexaoIEntregador
import com.example.vaialipramim.conexoes.ConexaoIPedido
import com.example.vaialipramim.conexoes.ConexaoIPost
import com.example.vaialipramim.dominios.Pedido
import com.example.vaialipramim.dominios.Post
import com.example.vaialipramim.dominios.Usuario
import com.example.vaialipramim.utils.AcessoSharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.util.ArrayList


class PrincipalSolicitante : AppCompatActivity(), LocationListener {

    lateinit var preferences: AcessoSharedPreferences
    lateinit var usuarioAnterior: Usuario;
    val IPost = ConexaoIPost.criar();
    val IPedido = ConexaoIPedido.criar();
    val IEntregador = ConexaoIEntregador.criar();
    var entregadoresProximos = java.util.ArrayList<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_solicitante)
        preferences = AcessoSharedPreferences(this)
        usuarioAnterior = preferences.AcessarUsuario("usuario")!!

        val locationManager: LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var ContadorDeLocalizacao = 0

        val tvNomeSolicitante = findViewById<TextView>(R.id.tv_nomeSolicitante)
        tvNomeSolicitante.setText(usuarioAnterior.nomeCompleto)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, Array<String>(5) {
                Manifest.permission.ACCESS_FINE_LOCATION
            }, 100)
        } else {
            if (ContadorDeLocalizacao == 0) {
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    100,
                    4.0f,
                    this
                );
                ContadorDeLocalizacao += 1
            }
        }
    }

    fun voltarInicial(view: View) {
        val voltarInicial = Intent(this, TelaInicial::class.java)
        startActivity(voltarInicial);
    }

    fun clickMenu(view: View) {
        val irMenu = Intent(this, TelaMenu::class.java)
        startActivity(irMenu);
    }

    override fun onLocationChanged(p0: Location) {
        // trazerEntregadoresProximos("-23.504460475448486, -46.714190454434885");
        var c = usuarioAnterior.coordenadas.split(',')
        trazerEntregadoresProximos("${c[0]},${c[1]}")

    }

    fun abrirMapa(view: View) {
        val mapaEntregadores = Intent(this, MapsActivity::class.java)
        startActivity(mapaEntregadores);
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
            statusPost.setTextColor(getColor(R.color.cinza))
        } else if (foiAceito == 3) {
            statusPost.setText(R.string.clique_para_solicitar)
        }
    }

    fun preecherTarefasPendentes(pedidosDoUsuario: List<Pedido>) {
        preferences.SalvarPedidos("pedidosDoUsuario", pedidosDoUsuario)
        val postsValidosParaNovasSolicitacao = ArrayList<Post>();

        val llEntregadoresProximos = findViewById<LinearLayout>(R.id.llEntregadores_proximos)
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

                if (pedidoParaEssePost == null) {
                    postsValidosParaNovasSolicitacao.add(post)
                    definirMensagemDeStatus(pedidoParaEssePost, 3, v)
                    v.setOnClickListener(object : View.OnClickListener {
                        override fun onClick(v: View?) {
                            preferences.SalvarPost("post_clickado", post)
                            abrirPost()
                        }
                    })

                    llEntregadoresProximos.addView(
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

        preferences.SalvarPosts(
            "postsValidosParaNovasSolicitacao",
            postsValidosParaNovasSolicitacao
        )
    }

    fun abrirPost() {
        val telaPost = Intent(this, Saldo::class.java)
        startActivity(telaPost);
    }

    fun abrirPedidosSolicitados(view: View) {
        val pedidosSolicitados = Intent(this, PedidosSolicitados::class.java)
        startActivity(pedidosSolicitados);
    }

    fun trazerPosts(arrayIds: String) {
        IPost.trazerPostsDeAlgunsUsuarios(arrayIds).enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                preferences.SalvarPosts("posts", response.body())
                trazerPedidosFeitosPorUsuario(usuarioAnterior.idUsuario)
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

    fun trazerPedidosFeitosPorUsuario(id: Int) {

        IPedido.trazerTodosPedidosDeUmUsuario(id).enqueue(object : Callback<List<Pedido>> {
            override fun onResponse(call: Call<List<Pedido>>, response: Response<List<Pedido>>) {
                if (response.body() != null)
                    preecherTarefasPendentes(response.body()!!)

            }

            override fun onFailure(call: Call<List<Pedido>>, t: Throwable) {
                println(t.toString())
                Toast.makeText(
                    baseContext,
                    "Infelizmente, não foi possivel trazer pedidos. Tente novamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun trazerEntregadoresProximos(posicaoSolicitante: String) {
        var idsEntregadores = "";

        IEntregador.trazerEntregadoresProximos(posicaoSolicitante)
            .enqueue(object : Callback<List<Usuario>> {
                override fun onResponse(
                    call: Call<List<Usuario>>,
                    response: Response<List<Usuario>>
                ) {
                    response.body()?.forEach {
                        entregadoresProximos.add(it)
                        idsEntregadores += "${it.idUsuario},"
                    }

                    preferences.SalvarEntregadores("entregadoresProximos", response.body())
                    trazerPosts(idsEntregadores)
                }

                override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
                    println(t.toString())
                    Toast.makeText(
                        baseContext,
                        "Infelizmente, não foi possivel trazer Entregadores Proximos. Tente novamente",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }

}