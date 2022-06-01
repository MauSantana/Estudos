package com.example.vaialipramim.dominios


class Post {

    val idPost: Int? = null
    var titulo: String? = null
    var dataHoraRealizacao: String? = null
    var descricao: String? = null
    var taxaEntrega: Double? = null
    var limiteQuantidadeItens: Int? = null
    var limitePesoEntrega = 0.0
    var localTarefa: String? = null
    var tempoEstimadoRealizacao: String? = null
    var foiEntregue: Int? = null
    var entregadorId: Int? = null

    constructor()

    override fun toString(): String {
        return "Post(idPost=$idPost, titulo=$titulo, dataHoraRealizacao=$dataHoraRealizacao, descricao=$descricao, taxaEntrega=$taxaEntrega, limiteQuantidadeItens=$limiteQuantidadeItens, limitePesoEntrega=$limitePesoEntrega, localTarefa=$localTarefa, tempoEstimadoRealizacao=$tempoEstimadoRealizacao, foiEntregue=$foiEntregue, entregadorId=$entregadorId)"
    }


}