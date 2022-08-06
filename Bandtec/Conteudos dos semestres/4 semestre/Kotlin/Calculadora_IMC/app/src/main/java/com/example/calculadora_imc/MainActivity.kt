package com.example.calculadora_imc

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun camposValidos(
        etNome: EditText,
        etIdade: EditText,
        etAltura: EditText,
        etPeso: EditText
    ): Boolean {

        /*
            Vamos verificar se nosso campo está vazio, acessando seu
            atributo text e verificando com o isEmpty() do kotlin;
        */
        if (etNome.text.isEmpty()) {
            /*
                Caso nosso campo esteja vazio, vamos inserir uma mensagem
                de erro através de seu atributo error, que mostrará a mensagem
                no campo e deixará um icone de erro ativo;
                Vamos também retornar false para que a chamada dessa função
                saiba que não deve prosseguir.
            */
            etNome.error = "Preencha um nome válido !"
            return false
        } else if (
            etIdade.text.isEmpty() ||
            etIdade.text.toString().toInt() <= 0
        ) {
            etIdade.error = "Informe uma idade válida !"
            return false
        } else if (
            etAltura.text.isEmpty() ||
            etAltura.text.toString().toInt() <= 0
        ) {
            etAltura.error = "Informe uma altura válida"
            return false
        } else if (
            etPeso.text.isEmpty() ||
            etPeso.text.toString().toDouble() <= 0
        ) {
            etPeso.error = "Informe um peso válido"
            return false
        } else {
            return true
        }
    }

    fun obterResultadoFaixaEtaria(imc: Double, idade: Int): String {
        /*
            Aqui vamos verificar a idade e o imc que recebemos pelos argumentos;
            O retorno é feito utilizando o operador ternário do Kotlin;
        */
        if (idade < 18) {
            return if (imc < 20) "bom" else "ruim"
        } else if (idade < 60) {
            return if (imc < 22) "bom" else "ruim"
        } else {
            return if (imc < 25) "bom" else "ruim"
        }
    }

    fun mostrarResultados(nome: String, imc: Double, idade: Int) {
        /*
            Essa forma de utilizar o findViewById descarta o uso
            de uma variável para apenas uma operação, como é o caso
            abaixo;
            Não podemos esquecer de colocar o tipo do componente que
            o findViewById irá encontrar, que é o valor entre < >.
        */
        findViewById<TextView>(R.id.tvIMC).text =
            "$nome Seu IMC é de ${"%.2f".format(imc)}"
        val resultadoFaixaEtaria = obterResultadoFaixaEtaria(imc, idade)
        findViewById<TextView>(R.id.tvFaixaEtaria).text =
            "Para sua faixa etária, seu resultado é $resultadoFaixaEtaria"
    }

    fun calcular(v: View) {

        /*
            Aqui vamos "encontrar" nosso componente do app pelo seu id;
            Perceba que tipamos a val etNome com EditText -> ou seja,
            o valor encontrado não é somente o que está digitado dentro
            do campo, mas o próprio campo como um objeto, isso é dessa forma
            para que possamos utilizar de seus métodos e atributos, como
            é o caso do .error que nos permite atribuir uma mensagem de erro
            ao campo caso necessário.
        */
        val etNome: EditText = findViewById(R.id.etNome)
        val etIdade: EditText = findViewById(R.id.etIdade)
        val etAltura: EditText = findViewById(R.id.etAltura)
        val etPeso: EditText = findViewById(R.id.etPeso)

        if (camposValidos(etNome, etIdade, etAltura, etPeso)) {
            val altura: Double = etAltura.text.toString().toDouble() / 100
            val alturaQuadrado: Double = altura * altura
            val imc: Double = etPeso.text.toString().toDouble() / alturaQuadrado

            mostrarResultados(etNome.text.toString(), imc, etIdade.text.toString().toInt())
        }
    }
}