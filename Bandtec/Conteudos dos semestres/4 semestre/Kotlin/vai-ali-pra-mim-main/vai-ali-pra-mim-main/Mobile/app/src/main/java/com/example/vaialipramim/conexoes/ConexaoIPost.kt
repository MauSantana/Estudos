package com.example.vaialipramim.conexoes

import com.example.vaialipramim.Interfaces.IPost
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoIPost {

    fun criar() : IPost {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://vapm-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(IPost::class.java)

        return api;
    }
}