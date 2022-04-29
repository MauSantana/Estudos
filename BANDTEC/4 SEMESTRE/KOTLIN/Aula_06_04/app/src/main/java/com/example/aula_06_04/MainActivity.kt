package com.example.aula_06_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.aula_06_04.modules.Filme
import com.example.aula_06_04.rest.Rest
import com.example.aula_06_04.services.FilmesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var etFilme: EditText
    private lateinit var layoutContainer: LinearLayout
    private val retrofit = Rest.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etFilme = findViewById(R.id.et_filme)
        layoutContainer = findViewById(
            R.id.filmes_container
        )
    }

    fun buscarPorId(view: View){
        val id = etFilme.text.toString().toLong()
        val filmesRequest = retrofit.create(FilmesService::class.java)
        filmesRequest.getById(id).enqueue(object: Callback<Filme> {
            override fun onResponse(call: Call<Filme>, response: Response<Filme>) {
                if (response.isSuccessful){
                    val filmeTitulo = response.body()?.title
                    val tvFilme = TextView(baseContext)
                    tvFilme.text = filmeTitulo
                    layoutContainer.removeAllViews()
                    layoutContainer.addView(tvFilme)
                }else {
                    Toast.makeText(baseContext, "Deu ruim, mas nem tanto pç",
                        Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Filme>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    fun buscarTodos(view: View){
        val filmesRequest = retrofit.create(FilmesService::class.java)
        filmesRequest.list().enqueue(object: Callback<List<Filme>>{
            override fun onResponse(call: Call<List<Filme>>, response: Response<List<Filme>>) {
                if (response.isSuccessful){
                    response.body()?.iterator()?.forEach {
                        filme -> val tvFilme = TextView(baseContext)
                        tvFilme.text = filme.title
                        layoutContainer.addView(tvFilme)
                    }
                } else {
                    Toast.makeText(baseContext, "Deu ruim, mas nem tanto pç",
                    Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Filme>>, objetoDeErro: Throwable) {
                Toast.makeText(
                    baseContext, objetoDeErro.message,Toast.LENGTH_LONG
                ).show()
            }

        })
    }
}