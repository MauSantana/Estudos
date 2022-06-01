package com.example.vaialipramim.conexoes

import com.example.vaialipramim.Interfaces.IEntregador
import com.example.vaialipramim.Interfaces.IUsuario
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoIEntregador {

    fun criar(): IEntregador {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://vapm-geomatching.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(IEntregador::class.java)

        return api;
    }
}