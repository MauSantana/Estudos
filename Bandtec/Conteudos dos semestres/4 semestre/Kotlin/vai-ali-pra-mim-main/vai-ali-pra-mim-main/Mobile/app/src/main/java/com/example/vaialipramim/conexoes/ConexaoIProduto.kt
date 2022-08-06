package com.example.vaialipramim.conexoes

import com.example.vaialipramim.Interfaces.IProduto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoIProduto {

    fun criar() : IProduto {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://vapm-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(IProduto::class.java)

        return api;
    }
}