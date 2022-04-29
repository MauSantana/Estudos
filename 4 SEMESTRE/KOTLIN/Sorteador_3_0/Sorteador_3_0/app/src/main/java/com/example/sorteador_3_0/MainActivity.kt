package com.example.sorteador_3_0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.content.res.AppCompatResources

class MainActivity : AppCompatActivity() {

    private var saldoAtual: Double = 120.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /*
        essa função serve para validarmos os campos digitados pelo usuário
        recebendo o palpite, a aposta e allIn (aposta tudo)

        somente se allIn não estiver true, verificamos o valor da aposta digitado pelo usuário.
     */
    fun camposValidos(
        etPalpite: EditText,
        etAposta: EditText,
        allIn: Boolean,
    ): Boolean {
        if (etPalpite.text.toString().isEmpty()) {
            etPalpite.error = "Valor inválido !"
            return false
        } else if (etPalpite.text.toString().toInt() !in 1..6) {
            etPalpite.error = "Valor deve estar entre 1 e 6"
            return false
        } else if (!allIn) {
            if (etAposta.text.toString().isEmpty()) {
                etAposta.error = "Valor inválido !"
                return false
            } else if (etAposta.text.toString().toDouble() <= 0.0) {
                etAposta.error = "Valor deve ser acima de 0 !"
                return false
            } else if (etAposta.text.toString().toDouble() > saldoAtual) {
                etAposta.error = "Não aposte mais do que tem !"
                return false
            }
        }
        return true
    }

    // sorteador de 1 a 6 para exibir o dado sorteado
    fun sortear(): Int = (Math.random() * 6 + 1).toInt()

    /*
        função que é chamada após a aposta e atualiza a carteira do usuário de acordo com o novo valor.

        aqui utilizamos o AppCompatResources  para transformar nossos "resources"
        que seriam as cores localizadas no diretório "values" dentro do arquivo colors.xml
        em uma propriedade para ser usada posteriormente pelo setTextColor da tag TextView.
    */
    fun atualizarCarteira() {
        val tvCarteira: TextView = findViewById(R.id.tv_carteira)
        tvCarteira.text = saldoAtual.toString()
        if (saldoAtual <= 0.0) {
            tvCarteira.setTextColor(
                AppCompatResources.getColorStateList(
                    baseContext,
                    R.color.primary_red
                )
            )
        }
    }

    /*
        na função de validarResultado, ela é chamada recebendo os seguintes parametros:
        allIn, numeroSorteado (que é o retorno da função sortear) e o palpite do usuário;

        pegamos o valor da aposta que o usuário digitou e verificamos se ele selecionou a
        opção de allIn para apostar tudo, se ele selecionou, pegamos o saldo atual dele e
        atribuimos a aposta, se não, pegamos o valor que ele apostou e multiplicamos por 2;

        caso o usuário acerte, pegamos esse valor que ele apostou já multiplicado e
        somamos ao saldo atual exibindo um texto de "Parabéns, você acertou + o valor apostado.
     */
    fun validarResultado(allIn: Boolean, numeroSorteado: Int, palpite: Int) {
        var valorAposta = findViewById<EditText>(R.id.et_valor_aposta)
            .text.toString().toDouble()

        if(allIn) {
            valorAposta = saldoAtual
        } else {
            valorAposta *= 2
        }
        if (numeroSorteado == palpite) {
            saldoAtual += valorAposta
            findViewById<TextView>(R.id.tv_resultado).text =
                "Parabéns, você acertou +$valorAposta"
        } else {
            saldoAtual -= valorAposta
            findViewById<TextView>(R.id.tv_resultado).text =
                "Infelizmente você errou -$valorAposta"
        }
        atualizarCarteira()
    }

    /*
        na função atualizarImagemSorteio, recebemos o numeroSorteado e mostramos o dado de acordo com o número equivalente.

        aqui utilizamos o AppCompatResources  para transformar nossos "resources"
        que seriam as imagens em um objeto "desenhável" para ser usado posteriormente pelo setImageDrawable da tag ImageView.

        O seguinte código R.drawable.ic_dado_1 serve para acessarmos o diretório de desenhaveis e pegar qualquer componente do mesmo.

        R: Um objeto global que indica nossos recursos do projeto
        drawable: propriedade que lista nossos componentes que estão dentro do diretório
        ic_dados_1: nossa imagem convertida em vector

    */
    fun atualizarImagemSorteio(numeroSorteado: Int) {
        val imagem = when (numeroSorteado) {
            1 -> AppCompatResources.getDrawable(baseContext, R.drawable.ic_dadoum)
            2 -> AppCompatResources.getDrawable(baseContext, R.drawable.ic_dadodois)
            3 -> AppCompatResources.getDrawable(baseContext, R.drawable.ic_dadotres)
            4 -> AppCompatResources.getDrawable(baseContext, R.drawable.ic_dadoquatro)
            5 -> AppCompatResources.getDrawable(baseContext, R.drawable.ic_dadocinco)
            else -> AppCompatResources.getDrawable(baseContext, R.drawable.ic_dadoseis)
        }
        findViewById<ImageView>(R.id.iv_dado).setImageDrawable(imagem)
    }

    /*
        a função validarParada verifica se o switch está marcado para, se estiver,
        quando o usuário chegar ao valor de zero na carteira, desativar os botões de aposta;

        neste trecho de código é possível observar a propriedade "visibility" do nosso elemento,
        nela temos o valor de View.GONE que indica que o elemento "se foi", tornando o mesmo
        invisível como se ele não existisse;

        View.GONE = oculta o componente e tira ele da tela
        View.INVISIBLE = que só oculta o componente mas não tira ele da tela
        View.VISIBLE = desoculta o componente mesmo se ele estava em "GONE" ou "INVISIBLE"

    */
    fun validarParada() {
        val swParar: Switch = findViewById(R.id.sw_parar)
        if (swParar.isChecked) {
            if (saldoAtual <= 0.0) {
                findViewById<Button>(R.id.btn_apostar).visibility =
                    View.GONE
                findViewById<Button>(R.id.btn_all_in).visibility =
                    View.GONE
            }
        }
    }

    /*
        a função apostar é chamada no click dos botões "Apostar" e "All in",
        nela pegamos pegamos os valores do palpite e da aposta digitados pelo usuário,
        validamos os campos, validamos o resultado de acordo com o número sorteado e o número digitado,
        exibe a imagem do dado de acordo com o número sorteado, e
        valida a switch de parar para evitar saldos negativos.
    */
    fun apostar(elemento: View) {
        val allIn: Boolean = when(elemento.id) {
            R.id.btn_all_in -> true
            else -> false
        }
        val etPalpite: EditText =
            findViewById(R.id.et_palpite)
        val etAposta: EditText =
            findViewById(R.id.et_valor_aposta)
        if (camposValidos(etPalpite, etAposta, allIn)) {
            val numeroSorteado = sortear()
            validarResultado(allIn, numeroSorteado, etPalpite.text.toString().toInt())
            atualizarImagemSorteio(numeroSorteado)
            validarParada()
        }
    }
}
