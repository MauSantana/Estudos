package com.example.vaialipramim.Interfaces

import com.example.vaialipramim.dominios.Produto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IProduto {

    @GET("produtos")
    fun trazerTodos(): Call<List<Produto>>

    @GET("produtos/{id}")
    fun trazerUm(@Path("id") id:Int): Call<Produto>

    @GET("produtos/nomes")
    fun trazerNomesProdutos(): Call<List<String>>
}