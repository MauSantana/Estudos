package com.example.aula_06_04.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {
    val baseUrl = "https://61c71fed90318500175472ff.mockapi.io/api/"
    fun getInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }
}