package com.example.vaialipramim.conexoes

import com.example.vaialipramim.Interfaces.IUsuario
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoIUsuario {

    fun criar() :IUsuario{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://vapm-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(IUsuario::class.java)

        return api;
    }
}