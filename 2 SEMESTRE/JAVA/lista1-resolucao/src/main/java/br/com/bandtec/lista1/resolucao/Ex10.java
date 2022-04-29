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
public class Ex10 {

    public static void main(String[] args) {
        
        Scanner leitorNumeros = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        String nome = leitorTexto.nextLine();
        
        System.out.println("Tempo de aquecimento:");
        Integer aquecimento = leitorNumeros.nextInt();

        System.out.println("Tempo de exercícios aeróbicos:");
        Integer aerobicos = leitorNumeros.nextInt();

        System.out.println("Tempo de musculação:");
        Integer musculacao = leitorNumeros.nextInt();

        Integer calorias = (aquecimento * 12) + (aerobicos * 20) + (musculacao * 25);

        System.out.println(String.
                format("Olá, %s. Você fez um total de %d minutos de exercícios e perdeu cerca de %d calorias.",
                        nome, (aquecimento + aerobicos + musculacao), calorias));
    }
}
