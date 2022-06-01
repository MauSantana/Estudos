package com.example.vaialipramim.Interfaces

import com.example.vaialipramim.dominios.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IEntregador {
    @GET("coordenadas/{posicaoSolicitante}")
    fun trazerEntregadoresProximos(@Path("posicaoSolicitante") posicaoSolicitante: String): Call<List<Usuario>>

    @GET("coordenadas/{posicaoSolicitante}/trazerTodos")
    fun trazerEntregadores(@Path("posicaoSolicitante") posicaoSolicitante: String): Call<List<Usuario>>
}