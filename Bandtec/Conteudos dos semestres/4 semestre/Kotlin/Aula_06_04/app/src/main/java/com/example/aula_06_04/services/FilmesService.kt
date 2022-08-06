package com.example.aula_06_04.services

import com.example.aula_06_04.modules.Filme
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmesService {

    @GET("/filme")
    fun list(): Call<List<Filme>>

    @GET("/filme/{id}")
    fun getById(@Path("id") id: Long): Call<Filme>
}

















