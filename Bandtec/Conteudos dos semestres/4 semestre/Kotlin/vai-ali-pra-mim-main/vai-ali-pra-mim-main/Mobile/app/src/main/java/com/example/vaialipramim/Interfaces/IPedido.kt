package com.example.vaialipramim.Interfaces;

import com.example.vaialipramim.dominios.Pedido
import com.example.vaialipramim.dominios.Post;

import retrofit2.Call;
import retrofit2.http.*

public interface IPedido {

    @GET("pedidos")
    fun trazerTodos(): Call<List<Pedido>>

    @GET("pedidos/{id}")
    fun trazerUm(@Path("id") id:Int): Call<Pedido>

    @GET("pedidos/usuario/{id}")
    fun trazerTodosPedidosDeUmUsuario(@Path("id") id:Int): Call<List<Pedido>>

    @GET("pedidos/posts/{postId}")
    fun trazerPedidosDeUmPost(@Path("postId") id:Int): Call<List<Pedido>>

    @GET("pedidos/posts/{postId}/abertos")
    fun trazerPedidosAbertosDeUmPost(@Path("postId") id:Int): Call<List<Pedido>>

    @GET("pedidos/posts/{postId}/aceitos")
    fun trazerPedidosAceitosDeUmPost(@Path("postId") id:Int): Call<List<Pedido>>

    @GET("pedidos/posts/{postId}/recusados")
    fun trazerPedidosRecusadosDeUmPost(@Path("postId") id:Int): Call<List<Pedido>>

    @GET("pedidos/usuario/{id}/visao")
    fun trazerTodosPedidosDeUmUsuarioPostId(@Path("id") id:Int): Call<List<String>>

    @POST("pedidos")
    fun criar(@Body pedido: Pedido):Call<Void>

    @PATCH("pedidos/{id}/aceitar")
    fun aceitarPedido(@Path("id") id:Int): Call<Void>

    @PATCH("pedidos/{id}/rejeitar")
    fun rejeitarPedido(@Path("id") id:Int): Call<Void>
}
