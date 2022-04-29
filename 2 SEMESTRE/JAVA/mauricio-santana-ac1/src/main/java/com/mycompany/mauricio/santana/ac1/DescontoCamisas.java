/*

CONTEXTO: Desenvolvimento de um programa que calcula o valor de desconto dos clientes em relação as compras de camisas e 
monitorar o fluxo de caixa da empresa.

BENEFÍCIOS: *Automatizar os calculos no ato da compra;
            *Alcançar um numero maior de clientes;
            *Trazer custo-benefício aos clientes da loja;
            *Monitorar o número de compras;
            *Monitorar os valores de lucro da loja.

 */
package com.mycompany.mauricio.santana.ac1;

import java.util.Scanner;

public class DescontoCamisas {
     
    public static void main(String[] args) {

//--Variaveis

String tipoCamisa;

Integer quant = 0;

Double preco = 0.0;

Double total = 0.0;

//--Leitores

Scanner leitorNome = new Scanner(System.in);

Scanner leitorInt = new Scanner(System.in);

Scanner leitorDou = new Scanner(System.in);

//--Entradas

System.out.println("Tipo da camisa: ");
tipoCamisa = leitorNome.nextLine();

do {

System.out.println("Preço do produto: (Produtos acima de R$50 recebem desconto de 10% )");
preco = leitorDou.nextDouble();

      } while (preco <= 0.0);

 do {

System.out.println("Quantidade: (escolha um numero entre 1 e 10)");
quant = leitorNome.nextInt();
            
        } while (quant <= 0 || quant > 10);


//--Calculo 

if( preco >= 50.0){

Double desconto = preco * 0.1;
total = (preco - desconto) * quant;
System.out.println("Você recebeu desconto em sua compra :)");

  } else {
total = preco * quant;
System.out.println("Você não recebeu desconto :(");

}


//--Saida




 System.out.println(String.format("Você comprou %d camisas %s, sua compra ficou com o valor de: %.2f", quant, tipoCamisa, total));

 }
}
