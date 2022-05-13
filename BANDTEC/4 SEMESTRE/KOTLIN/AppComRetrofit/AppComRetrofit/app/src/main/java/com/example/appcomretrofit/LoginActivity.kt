package com.example.appcomretrofit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appcomretrofit.models.AuthRequest
import com.example.appcomretrofit.models.AuthResponse
import com.example.appcomretrofit.rest.Rest
import com.example.appcomretrofit.services.AuthService
import com.example.appcomretrofit.utils.Validator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private val retrofit = Rest.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
    }

    fun login(view: View) {
        if (!Validator.emailIsFine(etEmail.text.toString())) {
            etEmail.error = "E-mail inválido"
        } else if (!Validator.passwordIsFine(etPassword.text.toString())) {
            etPassword.error = "Senha inválida"
        } else {
            val request = retrofit
                .create(AuthService::class.java)
            val authRequest = AuthRequest(
                etEmail.text.toString(),
                etPassword.text.toString()
            )
            request.login(authRequest).enqueue(object : Callback<AuthResponse> {
                override fun onResponse(
                    call: Call<AuthResponse>,
                    response: Response<AuthResponse>
                ) {
                    if (response.isSuccessful) {
                        val editor = getSharedPreferences(
                            "ACESSO",
                            Context.MODE_PRIVATE
                        ).edit()
                        editor.putString("jwt_token", response.body()?.token)
                        editor.apply()
                        // editor.commit()
                        startActivity(
                            Intent(
                                baseContext,
                                MainActivity::class.java,
                            )
                        )
                    } else if (response.code() == 403) {
                        Toast.makeText(
                            baseContext,
                            "Usuário e/ou senha estão incorretos",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                    Toast.makeText(
                        baseContext,
                        t.message,
                        Toast.LENGTH_LONG
                    )
                        .show()
                }

            })
        }
    }
}