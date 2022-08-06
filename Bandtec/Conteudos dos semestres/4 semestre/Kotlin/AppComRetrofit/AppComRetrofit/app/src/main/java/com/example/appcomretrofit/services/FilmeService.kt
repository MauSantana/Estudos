package com.example.appcomretrofit.services

import com.example.appcomretrofit.models.Filme
import retrofit2.Call
import retrofit2.http.*

interface FilmeService {

    @GET("/filmes")
    fun list(
        @Header("Authorization") token: String?
    ): Call<List<Filme>>

    @GET("/filmes/{id}")
    fun getById(
        @Path("id") id: Long,
        @Header("Authorization") token: String?,
    ): Call<Filme>

    @DELETE("/filmes/{id}")
    fun remove(
        @Path("id") id: Long,
        @Header("Authorization") token: String?,
    ): Call<Void>

    @POST("/filmes")
    fun save(
        @Header("Authorization") token: String?,
    )

    @PUT("/filmes/{id}")
    fun update(
        @Header("Authorization") token: String?
    )

}