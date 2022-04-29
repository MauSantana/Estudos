/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bandtec.lista1.resolucao;

import java.util.Scanner;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class Ex04 {
    
    public static void main(String[] args) {
        
        Scanner leitorNumero = new Scanner(System.in);
        
        System.out.println("Digite o valor unitário de um produto:");
        Double valorProduto = leitorNumero.nextDouble();
        
        System.out.println("Digite a quantidade vendida:");
        Integer quantidadeVendida = leitorNumero.nextInt();
        
        System.out.println("Digite o valor pago pelo cliente:");
        Double valorPago = leitorNumero.nextDouble();
        
        System.out.println(String.format("Troco para o cliente: R$%.2f",
                (valorPago - (valorProduto*quantidadeVendida))));
    }
}
