package com.example.vaialipramim.Interfaces

import com.example.vaialipramim.dominios.Token
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IToken {
    @GET("token")
    fun trazerToken(): Call<List<Token>>

    @POST("token365")
    fun criarToken(@Body token: Token): Call<Void>

    @POST("token/codeVerification")
    fun verificarToken(@Body token: Token ): Call<Void>

}