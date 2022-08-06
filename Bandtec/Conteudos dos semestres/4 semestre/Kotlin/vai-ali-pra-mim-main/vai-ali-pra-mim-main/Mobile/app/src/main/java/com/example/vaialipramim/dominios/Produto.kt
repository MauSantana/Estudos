package com.example.vaialipramim.dominios

data class Produto(

    var idProduto: Int = 0,
    var nomeProduto: String,
    var tipoProduto: String,
    var valor: Double = 0.0,
    var marca: String
) {

    constructor(

    ) : this(
        nomeProduto = "",
        tipoProduto = "",
        valor = 0.0,
        marca = "",
        idProduto = 0
    )

    constructor(
        idProduto: Int
    ) : this(
        nomeProduto = "",
        tipoProduto = "",
        valor = 0.0,
        marca = "",
        idProduto = idProduto
    )


    override fun toString(): String {
        return "Produto(idProduto=$idProduto, nomeProduto='$nomeProduto', tipoProduto='$tipoProduto', valor=$valor, marca='$marca')"
    }
}
