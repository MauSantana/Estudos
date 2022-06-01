package com.example.vaialipramim.conexoes

import com.example.vaialipramim.Interfaces.IToken
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoToken {

    fun criar(): IToken{
        val retrofit  = Retrofit.Builder()
            .baseUrl("https://vapm-emailsender.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(IToken::class.java)

        return api
    }
}