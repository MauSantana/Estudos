package com.example.vaialipramim.components;

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import com.example.vaialipramim.R
import com.example.vaialipramim.conexoes.ConexaoIPedido
import com.example.vaialipramim.dominios.Pedido
import com.example.vaialipramim.dominios.Produto
import com.example.vaialipramim.telas.PrincipalSolicitante
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

public class Modal() {
    private var produto1: Produto = Produto()
    private var qtdItem1: Int = 0
    private var produto2: Produto = Produto()
    private var qtdItem2: Int = 0
    private var valorTotalCompras: Double = 0.0
    private var taxaEntrega: Double = 0.0
    val IPedido = ConexaoIPedido.criar();

    fun configurarModal(
        produto1: Produto,
        qtdItem1: Int,
        produto2: Produto,
        qtdItem2: Int,
        taxaEntrega: Double,
        valorTotalCompras: Double
    ) {
        this.produto1 = produto1
        this.qtdItem1 = qtdItem1
        this.produto2 = produto2
        this.qtdItem2 = qtdItem2
        this.taxaEntrega = taxaEntrega
        this.valorTotalCompras = valorTotalCompras
    }

    fun show(
        view: AppCompatActivity,
        pedido: Pedido

    ) {
        val vi: LayoutInflater =
            view.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = vi.inflate(R.layout.componenet_modal, null)

        var alertDialog = AlertDialog.Builder(view).create()
        alertDialog.setView(v)

        val item1 = v.findViewById<TextView>(R.id.ed_item_1)
        item1.setText("* ${qtdItem1} - ${produto1.nomeProduto}:  ${produto1.valor}")
        val item2 = v.findViewById<TextView>(R.id.ed_item_2)
        item2.setText("* ${qtdItem2} - ${produto2.nomeProduto}:  ${produto2.valor}")
        val taxa_entrega = v.findViewById<TextView>(R.id.ed_taxa_entrega)
        taxa_entrega.setText("- Taxa de entrega: R$ ${pedido.taxaEntrega}")
        val valorTotal = v.findViewById<TextView>(R.id.ed_valor_total)
        valorTotal.setText("- Valor total: R$ ${Math.round(valorTotalCompras)}")

        val button_ok = v.findViewById<Button>(R.id.button_ok)

        button_ok.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                fazerSolicitacao(pedido, view)
                alertDialog.dismiss()
            }
        })

        val button_cancelar_ = v.findViewById<Button>(R.id.button_cancelar)

        button_cancelar_.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                alertDialog.dismiss()
            }
        })

        alertDialog.show()
    }

    fun showModalPedido(
        view: AppCompatActivity,
        pedido: Pedido,
        produtos: List<Produto>

    ) {
        val vi: LayoutInflater =
            view.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = vi.inflate(R.layout.componenet_modal, null)

        var alertDialog = AlertDialog.Builder(view).create()
        alertDialog.setView(v)

        val ids = pedido.produtosIds.split(';')

        produtos.forEach { produto ->
            if (produto.idProduto == ids[0].split('-')[0].toInt())
                pedido.produtos.add(Pair(produto, ids[0].split('-')[1].toInt()))
        }

        produtos.forEach { produto ->
            if (produto.idProduto == ids[1].split('-')[0].toInt())
                pedido.produtos.add(Pair(produto, ids[1].split('-')[1].toInt()))
        }


        val produto1 = pedido.produtos[0]
        val produto2 = pedido.produtos[1]


        val ed_titulo = v.findViewById<TextView>(R.id.ed_titulo)
        ed_titulo.setVisibility(View.GONE);
        val item1 = v.findViewById<TextView>(R.id.ed_item_1)
        item1.setText("* ${produto1.second} - ${produto1.first.nomeProduto}:  ${produto1.first.valor}")
        val item2 = v.findViewById<TextView>(R.id.ed_item_2)
        item2.setText("* ${produto2.second} - ${produto2.first.nomeProduto}:  ${produto2.first.valor}")
        val taxa_entrega = v.findViewById<TextView>(R.id.ed_taxa_entrega)
        taxa_entrega.setText("- Taxa de entrega: R$ ${pedido.taxaEntrega}")
        val valorTotal = v.findViewById<TextView>(R.id.ed_valor_total)
        valorTotal.setText("- Valor total: R$ ${Math.round(pedido.valorTotalCompras)}")

        val button_ok = v.findViewById<Button>(R.id.button_ok)
        button_ok.setVisibility(View.GONE);





        val button_cancelar_ = v.findViewById<Button>(R.id.button_cancelar)
        button_cancelar_.setText(R.string.fechar)
        button_cancelar_.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                alertDialog.dismiss()
            }
        })

        alertDialog.show()

    }

    fun fazerSolicitacao(pedido: Pedido, view: AppCompatActivity) {
        IPedido.criar(pedido).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(view, "Solicitação feita com sucesso", Toast.LENGTH_SHORT)
                    .show()

                val voltar = Intent(view.baseContext, PrincipalSolicitante::class.java)
                view.startActivity(voltar)
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(
                    view,
                    "Não foi possível enviar código. Tente novamente",
                    Toast.LENGTH_SHORT
                ).show()
                println(t.message)
            }
        })
    }

}