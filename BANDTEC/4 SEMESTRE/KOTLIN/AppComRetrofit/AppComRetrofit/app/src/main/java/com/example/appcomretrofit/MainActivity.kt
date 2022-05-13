package com.example.appcomretrofit

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomretrofit.adapters.FilmeAdapter
import com.example.appcomretrofit.databinding.ActivityMainBinding
import com.example.appcomretrofit.models.Filme
import com.example.appcomretrofit.rest.Rest
import com.example.appcomretrofit.services.FilmeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class   MainActivity : AppCompatActivity() {

    private val retrofit = Rest.getInstance().create(FilmeService::class.java)
    private lateinit var etId: EditText
    private lateinit var llContainer: LinearLayout
    private lateinit var recyclerView: RecyclerView

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startUI()
    }

    private fun startUI() {
        llContainer = binding.llFilmesContainer
        etId = binding.etId
        findViewById<Button>(R.id.btn_buscar_filme).setOnClickListener {
            getMovieById()
        }
        findViewById<Button>(R.id.btn_buscar_todos).setOnClickListener {
            listMovies()
        }
        findViewById<Button>(R.id.btn_remove_movie).setOnClickListener {
            removeMovie()
        }
        recyclerView = findViewById(R.id.filmesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
    }

    fun removeMovie() {
        if (etId.text.isNullOrEmpty()) {
            etId.error = "Insira um valor válido de ID"
        } else {
            val id = etId.text.toString().toLong()
            val prefs = getSharedPreferences(
                "ACESSO",
                Context.MODE_PRIVATE
            )
            val token = prefs.getString("jwt_token", "")
            retrofit.remove(id, token).enqueue(object : Callback<Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(
                            baseContext,
                            "Filme removido com sucesso",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(
                    call: Call<Void>,
                    t: Throwable
                ) {
                    Toast.makeText(
                        baseContext,
                        t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }

            })
        }
    }

    fun listMovies() {
        val prefs = getSharedPreferences("ACESSO", Context.MODE_PRIVATE)
        val token = prefs?.getString("jwt_token", "")
        retrofit.list(token).enqueue(object : Callback<List<Filme>> {
            override fun onResponse(call: Call<List<Filme>>, response: Response<List<Filme>>) {
                if (response.isSuccessful) {
                    val filmesList = mutableListOf<Filme>()
                    response.body()?.forEach { filme ->
                        filmesList.add(filme)
                    }
                    recyclerView.adapter = FilmeAdapter(
                        filmesList
                    ) {
                        val filme = it
                        Toast.makeText(
                            recyclerView.context,
                            "Clicou no filme ${filme.id}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            override fun onFailure(call: Call<List<Filme>>, t: Throwable) {
                Toast.makeText(
                    baseContext,
                    t.message,
                    Toast.LENGTH_LONG
                ).show()
            }

        })
    }

    fun getMovieById() {
        if (etId.text.isNullOrEmpty()) {
            etId.error = "Insira um valor de ID válido"
        } else {
            val id = etId.text.toString().toLong()

            val prefs = getSharedPreferences("ACESSO", Context.MODE_PRIVATE)
            val token = prefs.getString("jwt_token", "")

            retrofit.getById(id, token).enqueue(object : Callback<Filme> {
                override fun onResponse(call: Call<Filme>, response: Response<Filme>) {
                    if (response.isSuccessful) {
                        llContainer.removeAllViews()
                        val tvMovie = TextView(baseContext)
                        tvMovie.text = response.body()?.title
                        llContainer.addView(tvMovie)
                    } else {
                        Toast.makeText(
                            baseContext,
                            response.message(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<Filme>, t: Throwable) {
                    Toast.makeText(
                        baseContext,
                        t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }

            })
        }
    }
}