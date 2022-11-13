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
public class Ex02 {

    public static void main(String[] args) {
        
        Scanner leitorTexto = new Scanner(System.in);
        Scanner leitorNumeros = new Scanner(System.in);
        
        System.out.println("Digite seu nome:");
        String nome = leitorTexto.nextLine();
        
        System.out.println(String.format("Olá %s, Qual o seu ano de nascimento?",
                nome));
        Integer anoDeNascimento = leitorNumeros.nextInt();
        
        System.out.println(String.format("%s em 2030 você terá %d anos!",
                nome, (2030 - anoDeNascimento)));
    }
}
