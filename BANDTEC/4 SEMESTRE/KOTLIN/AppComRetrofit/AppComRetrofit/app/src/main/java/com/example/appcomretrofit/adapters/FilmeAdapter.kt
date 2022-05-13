package com.example.appcomretrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appcomretrofit.R
import com.example.appcomretrofit.models.Filme

class FilmeAdapter(
    val filmes: List<Filme>,
    val onClick: (Filme) -> Unit
) : RecyclerView.Adapter<FilmeAdapter.FilmesViewHolder>() {

    override fun getItemCount() = filmes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.filme_adapter, parent, false)
        return FilmesViewHolder(view)
    }

    class FilmesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvFilmeImage: ImageView = view.findViewById(R.id.tvFilmeImage)
        var tvFilmeTitle: TextView = view.findViewById(R.id.tvFilmeTitle)
        val tvFilmeDescription: TextView = view.findViewById(R.id.tvFilmeDescription)
    }

    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {
        val filme = filmes[position]
        val filmeImage = filme.imageUrl
        holder.tvFilmeTitle.text = filme.title
        holder.tvFilmeDescription.text = filme.description

        Glide
            .with(holder.itemView)
            .load(filmeImage)
            .into(holder.tvFilmeImage)
        /*
        * Aqui modificaremos as propriedades do nosso FilmesViewHolder
        * */
        holder.itemView.setOnClickListener {
            onClick(filme)
        }
    }
}