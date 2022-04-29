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
public class Ex08 {
    
    public static void main(String[] args) {
        
        Scanner leitorNumero = new Scanner(System.in);

        System.out.println("Filhos de 0 a 3 anos:");
        Integer criancas = leitorNumero.nextInt();

        System.out.println("Filhos de 4 a 16 anos:");
        Integer preAdolescentes = leitorNumero.nextInt();

        System.out.println("Filhos de 17 a 18 anos:");
        Integer adolescentes = leitorNumero.nextInt();

        Double bolsa = (criancas * 25.12) + (preAdolescentes * 15.88) + (adolescentes * 12.44);
        Integer totalFilhos = (criancas + preAdolescentes + adolescentes);

        System.out.println(String.format("Você tem um total de %d filhos e vai receber R$%.2f de bolsa",
                totalFilhos, bolsa));
    }
}
