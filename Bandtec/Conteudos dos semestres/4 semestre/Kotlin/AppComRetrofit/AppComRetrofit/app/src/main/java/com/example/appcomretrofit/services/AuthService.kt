package com.example.appcomretrofit.services

import com.example.appcomretrofit.models.AuthRequest
import com.example.appcomretrofit.models.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
    fun login(
        @Body authRequest: AuthRequest
    ): Call<AuthResponse>

}