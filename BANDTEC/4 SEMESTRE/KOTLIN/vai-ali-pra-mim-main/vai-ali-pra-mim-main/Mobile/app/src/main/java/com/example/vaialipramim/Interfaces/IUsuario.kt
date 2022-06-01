package com.example.vaialipramim.Interfaces

import com.example.vaialipramim.dominios.Usuario
import com.example.vaialipramim.dominios.UsuarioLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface IUsuario {
    @GET("usuarios")
    fun trazerUsuario(): Call<List<Usuario>>

    @GET("usuarios/{id}")
    fun trazerUmUsuario(@Path("id") id:Int): Call<Usuario>

    @POST("usuarios/login")
    fun login(@Body usuario: UsuarioLogin): Call<Usuario>

    @POST("usuarios")
    fun criar(@Body usuario: Usuario):Call<Void>




}