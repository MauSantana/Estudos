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
public class Ex05 {
    
    public static void main(String[] args) {
        
        Scanner leitorNumeros = new Scanner(System.in);
        
        System.out.println("Digite o salário:");
        Double salario = leitorNumeros.nextDouble();
        
        System.out.println("Digite o valor do imposto em '%' (número inteiro):");
        Double porcentagem = leitorNumeros.nextDouble() / 100;
        
        Double salarioLiquido = salario - (salario * porcentagem);
        
        System.out.println(String.format("\nSalário líquido: R$%.2f", 
                salarioLiquido));
    }
}
