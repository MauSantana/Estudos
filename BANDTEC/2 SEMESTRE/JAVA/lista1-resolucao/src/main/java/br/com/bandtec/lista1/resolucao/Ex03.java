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
public class Ex03 {
     
    public static void main(String[] args) {
        
        Scanner leitorNumeros = new Scanner(System.in);
        
        System.out.println("Digite o peso limite do elevador:");
        Double pesoMaximoElevador = leitorNumeros.nextDouble();
        
        System.out.println("Digite o número limite de pessoas em um elevador:");
        Integer numeroDePessoasTotal = leitorNumeros.nextInt();
        
        Double pesoTotal = 0.0;
        
        System.out.println("Digite o peso da primeira pessoa:");
        pesoTotal += leitorNumeros.nextDouble();
        
        System.out.println("Digite o peso da segunda pessoa:");
        pesoTotal += leitorNumeros.nextDouble();
        
        System.out.println("Digite o peso da terceira pessoa:");
        pesoTotal += leitorNumeros.nextDouble();
        
        System.out.println(String.format("\nEntraram 3 pessoas no elevador, no qual cabem %d",
                numeroDePessoasTotal));
        
        System.out.println(String.format("O peso total do elevador é %.2fkg sendo que ele suporta %.2fkg",
                pesoTotal, pesoMaximoElevador));
    }
}
