package com.example.vaialipramim.telas

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vaialipramim.R
import com.example.vaialipramim.dominios.Usuario
import com.example.vaialipramim.utils.AcessoSharedPreferences
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    lateinit var preferences: AcessoSharedPreferences
    lateinit var usuarioAnterior: Usuario;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        preferences = AcessoSharedPreferences(this)
        usuarioAnterior = preferences.AcessarUsuario("usuario")!!

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun addCircle(point: LatLng) {
        mMap.addCircle(
            CircleOptions()
                .center(LatLng(point.latitude, point.longitude))
                .radius(500.0)
                .strokeColor(Color.RED)
                .strokeWidth(8.0F)
                .fillColor(Color.TRANSPARENT)
        )
    }

    fun abrirPost() {
        val telaPost = Intent(this, Saldo::class.java)
        startActivity(telaPost);
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val entregadoresProximos = preferences.AcessarEntregadores("entregadoresProximos")
        val postsValidosParaNovasSolicitacao =
            preferences.AcessarPosts("postsValidosParaNovasSolicitacao")
        val solicitante = usuarioAnterior.formatarCoordenadas()

        mMap.addMarker(
            MarkerOptions().position(solicitante)
                .title(usuarioAnterior.nomeCompleto).icon(
                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)
                )
        )

        postsValidosParaNovasSolicitacao.forEach { post ->
            val entregadorDessePost = entregadoresProximos.filter { entregadoresProximos ->
                entregadoresProximos.idUsuario == post.entregadorId
            }.firstOrNull()

            val novoMarcador = entregadorDessePost?.formatarCoordenadas()
            mMap.addMarker(
                MarkerOptions().position(novoMarcador!!).snippet(entregadorDessePost.nomeCompleto)
                    .title(post.titulo).icon(
                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
                )
            )

            mMap.setOnInfoWindowClickListener {
                preferences.SalvarPost("post_clickado", post)
                abrirPost()
                println("abriu")
            }
        }

        addCircle(solicitante)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(solicitante))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(solicitante, 16F))
    }
}