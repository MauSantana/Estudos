package com.example.vaialipramim.dominios

import com.google.android.gms.maps.model.LatLng
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

data class Usuario(

    var idUsuario: Int,
    var nomeCompleto: String,
    var cPF: String,
    var dataNascimento: String,
    var email: String,
    var telefone: String,
    var cEP: String,
    var complemento: String,
    var saldo: Double = 0.0,
    var RG: String,
    var pontoReferencia: String,
    var senha: String,
    var coordenadas: String,
    var fotoRG: String,
    var fotoPerfil: String,
    var ehConsumidor: Int = 0
) {
    constructor(
        nomeCompleto: String,
        CPF: String,
        dataNascimento: String,
        email: String,
        senha: String,
        telefone: String,
        ehConsumidor: Int
    ) : this(
        idUsuario = 0,
        nomeCompleto = nomeCompleto,
        cPF = CPF,
        dataNascimento = dataNascimento,
        email = email,
        senha = senha,
        telefone = telefone,
        complemento = " ....",
        saldo = 0.0,
        RG = "",
        pontoReferencia = "",
        coordenadas = "",
        fotoRG = "",
        fotoPerfil = "",
        cEP = "00000000",
        ehConsumidor = ehConsumidor
    ) {
        this.nomeCompleto = nomeCompleto
        this.cPF = CPF
        this.dataNascimento = dataNascimento
        this.email = email
        this.senha = senha
        this.telefone = telefone
    }

    constructor(
    ) : this(
        idUsuario = 0,
        nomeCompleto = "",
        cPF = "",
        dataNascimento = "",
        email = "",
        senha = "",
        telefone = "",
        complemento = " ....",
        saldo = 0.0,
        RG = "",
        pontoReferencia = "",
        coordenadas = "",
        fotoRG = "",
        fotoPerfil = "",
        cEP = "00000000",
        ehConsumidor = 0
    )

    fun converterDatanascimento() {
        this.cEP = "00000000"
        this.complemento = ".. ."
        var c = this.dataNascimento.split('/')
        this.dataNascimento = "${c[2]}-${c[1]}-${c[0]}"
        println(this.dataNascimento)
    }

    fun formatarCoordenadas(): LatLng {
        val coordenadasSeparadas = coordenadas.split(',')
        val random = ThreadLocalRandom.current().nextDouble(0.0, 4.0);
        val coord = LatLng(
            coordenadasSeparadas[0].trim().toDouble() + (0.000150 * random),
            coordenadasSeparadas[1].trim().toDouble() + (0.000150 * random)
        )
        println("Coordenadas formatadas")
        println(coord.toString())
        return coord
    }

}







