package com.example.vaialipramim.dominios

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

data class Pedido(


    var idPedido: Int,
    var dataHora: String?,
    var taxaEntrega: Double,
    var estabelecimento: String,
    var produtosIds: String,
    var valorTotalCompras: Double,
    var postId: Int,
    var solicitanteId: Int,
    var foiAceito: Int,
    var foiEntregue: Int,
    var produtos: ArrayList<Pair<Produto, Int>>
) {

    constructor(
        idPedido: Int,
        dataHora: String?,
        taxaEntrega: Double,
        estabelecimento: String,
        produtosIds: String,
        valorTotalCompras: Double,
        postId: Int,
        solicitanteId: Int
    ) : this(
        idPedido = idPedido,
        dataHora = dataHora,
        taxaEntrega = taxaEntrega,
        estabelecimento = estabelecimento,
        produtosIds = produtosIds,
        valorTotalCompras = valorTotalCompras,
        postId = postId,
        solicitanteId = solicitanteId,
        foiAceito = 2,
        foiEntregue = 2,
        produtos = ArrayList()

    ) {
        this.idPedido = idPedido
        this.dataHora = dataHora
        this.taxaEntrega = taxaEntrega
        this.estabelecimento = estabelecimento
        this.produtosIds = produtosIds
        this.valorTotalCompras = valorTotalCompras
        this.postId = solicitanteId
    }

    constructor(

    ) : this(
        idPedido = 0,
        dataHora = "",
        taxaEntrega = 0.0,
        estabelecimento = "",
        produtosIds = "",
        valorTotalCompras = 0.0,
        postId = 0,
        solicitanteId = 1,
        foiAceito = 2,
        foiEntregue = 2,
        produtos = ArrayList()

    ) {
        this.idPedido = idPedido
        this.dataHora = dataHora
        this.taxaEntrega = taxaEntrega
        this.estabelecimento = estabelecimento
        this.produtosIds = produtosIds
        this.valorTotalCompras = valorTotalCompras
        this.postId = solicitanteId
    }

    fun formatarProdutoQuantidade() {
        val pairs = ArrayList<Pair<Produto, Int>>();

        val produtosQuantidades = produtosIds.split(";")
        val pq1 = produtosQuantidades[0]
        val pq1Cut = pq1.split('-')

        val pq2 = produtosQuantidades[1]
        val pq2Cut = pq2.split('-')

        pairs.add(Pair(Produto(pq1Cut[0].toInt()), pq1Cut[1].toInt()))

        pairs.add(Pair(Produto(pq2Cut[0].toInt()), pq2Cut[1].toInt()))

        this.produtos = pairs

    }
}


