package com.example.vaialipramim.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.vaialipramim.dominios.Pedido
import com.example.vaialipramim.dominios.Post
import com.example.vaialipramim.dominios.Produto
import com.example.vaialipramim.dominios.Usuario
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class AcessoSharedPreferences(context: Context) {

    var preferences: SharedPreferences = context.getSharedPreferences("autenticação", MODE_PRIVATE)
    val edit = preferences?.edit();

    fun AcessarUsuario(atributo: String): Usuario? {
        val gson = Gson()
        val json: String = preferences?.getString(atributo, null) ?: return null
        val usuario: Usuario = gson.fromJson(json, Usuario::class.java)

        return usuario
    }

    fun AcessarPosts(atributo: String): List<Post> {
        var arrayItems: List<Post> = mutableListOf()
        val serializedObject: String? = preferences.getString(atributo, null)
        if (serializedObject != null) {
            val gson = Gson()
            val type: Type = object : TypeToken<List<Post?>?>() {}.type
            arrayItems = gson.fromJson<List<Post>>(serializedObject, type)
        }

        return arrayItems;
    }

    fun AcessarEntregadores(atributo: String): List<Usuario> {
        var arrayItems: List<Usuario> = mutableListOf()
        val serializedObject: String? = preferences.getString(atributo, null)
        if (serializedObject != null) {
            val gson = Gson()
            val type: Type = object : TypeToken<List<Usuario>>() {}.type
            arrayItems = gson.fromJson<List<Usuario>>(serializedObject,type)
        }

        return arrayItems;
    }

    fun AcessarProdutos(atributo: String): List<Produto> {
        var arrayItems: List<Produto> = mutableListOf()
        val serializedObject: String? = preferences.getString(atributo, null)
        if (serializedObject != null) {
            val gson = Gson()
            val type: Type = object : TypeToken<List<Produto>>() {}.type
            arrayItems = gson.fromJson<List<Produto>>(serializedObject,type)
        }

        return arrayItems;
    }

    fun AcessarPedidos(atributo: String): List<Pedido> {
        var arrayItems: List<Pedido> = mutableListOf()
        val serializedObject: String? = preferences.getString(atributo, null)
        if(serializedObject == "null")
            return arrayItems

        if (serializedObject != null) {
            val gson = Gson()
            val type: Type = object : TypeToken<List<Pedido?>?>() {}.type
            arrayItems = gson.fromJson<List<Pedido>>(serializedObject, type)
        }

        return arrayItems;
    }

    fun AcessarStrings(atributo: String): List<String> {
        var arrayItems: List<String> = mutableListOf()
        val serializedObject: String? = preferences.getString(atributo, null)
        if (serializedObject != null) {
            val gson = Gson()
            val type: Type = object : TypeToken<List<String?>?>() {}.type
            arrayItems = gson.fromJson<List<String>>(serializedObject, type)
        }

        return arrayItems;
    }

    fun AcessarPost(atributo: String): Post? {
        val gson = Gson()
        val json: String = preferences?.getString(atributo, null) ?: return null
        val post: Post = gson.fromJson(json, Post::class.java)

        return post
    }

    fun AcessarValor(atributo: String): String? {
        val valor: String = preferences?.getString(atributo, null) ?: return null

        return valor;
    }

    fun <T> SalvarUsuario(nomeAtributo: String, usuario: T) {
        val gson = Gson()
        val json = gson.toJson(usuario)
        edit?.putString(nomeAtributo, json);

        edit?.apply()
    }

    fun SalvarEntregadores(key: String?, list: List<Usuario>?) {
        val gson = Gson()
        val json = gson.toJson(list)
        this.edit.putString(key, json);

        edit.commit();
    }

    fun SalvarProdutos(key: String?, list: List<Produto>?) {
        val gson = Gson()
        val json = gson.toJson(list)
        this.edit.putString(key, json);

        edit.commit();
    }

    fun  SalvarPosts(key: String?, list: List<Post>?) {
        val gson = Gson()
        val json = gson.toJson(list)
        this.edit.putString(key, json);

        edit.commit();
    }

    fun  SalvarStrings(key: String?, list: List<String>?) {
        val gson = Gson()
        val json = gson.toJson(list)
        this.edit.putString(key, json);

        edit.commit();
    }

    fun  SalvarValor(key: String, valor: String) {
        this.edit.putString(key, valor);

        edit.commit();
    }

    fun  SalvarPedidos(key: String?, list: List<Pedido>?) {
        val gson = Gson()
        val json = gson.toJson(list)
        this.edit.putString(key, json);

        edit.commit();
    }

    fun SalvarPost(key: String?, post: Post) {
        val gson = Gson()
        val json = gson.toJson(post)
        this.edit.putString(key, json);

        edit.commit();
    }

    fun ResetarPreferences(){
        edit.clear().commit();
    }

    fun ResetarAtributo(key: String?){
        edit.remove(key);
        edit.apply();
    }
}