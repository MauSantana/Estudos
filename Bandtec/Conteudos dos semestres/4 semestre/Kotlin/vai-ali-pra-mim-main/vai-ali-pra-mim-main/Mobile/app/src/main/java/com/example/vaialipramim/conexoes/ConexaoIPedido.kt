package com.example.vaialipramim.conexoes

import com.example.vaialipramim.Interfaces.IPedido
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoIPedido {

    fun criar() : IPedido {
        val retrofit = Retrofit.Builder()

           // .baseUrl("https://vapm-api.herokuapp.com")
            .baseUrl("https://vapm-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(IPedido::class.java)

        return api;
    }
}