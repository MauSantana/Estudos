package com.example.vaialipramim.Interfaces

import com.example.vaialipramim.dominios.Post
import com.example.vaialipramim.dominios.Usuario
import retrofit2.Call
import retrofit2.http.*

interface IPost {

    @GET("posts")
    fun trazerTodos(): Call<List<Usuario>>

    @GET("posts/{id}")
    fun trazerUm(@Path("id") id:Int): Call<Post>

    @GET("posts/usuarios/{arrayIds}")
    fun trazerPostsDeAlgunsUsuarios(@Path("arrayIds") arrayIds:String): Call<List<Post>>
    @GET("posts/usuarios/{arrayIds}/abertos")
    fun trazerPostsAbertoDeAlgunsUsuarios(@Path("arrayIds") arrayIds:String): Call<List<Post>>

    @POST("posts")
    fun criarPost(@Body post: Post):Call<Void>

    @DELETE("posts/{id}")
    fun deletarPost(@Path("id") id:Int):Call<Void>
}