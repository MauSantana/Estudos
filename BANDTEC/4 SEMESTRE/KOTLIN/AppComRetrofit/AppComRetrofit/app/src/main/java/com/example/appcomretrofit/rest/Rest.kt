package com.example.appcomretrofit.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {
//    private val baseUrl = "http://10.0.2.2:3000/"
    // Em caso de uso no celular:
    private val baseUrl = "http://192.168.255.38:3000/"

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}