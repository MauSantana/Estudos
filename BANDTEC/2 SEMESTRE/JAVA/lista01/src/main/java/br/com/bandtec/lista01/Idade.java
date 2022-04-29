
package br.com.bandtec.lista01;

import java.util.Scanner;


public class Idade {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite seu nome: ");
        String nome = leitor.nextLine();
        
        System.out.println(String.format("Olá %s! Qual o ano de seu nascimento?", nome));
        Integer ano = leitor.nextInt();
        Integer calculo = (2030 - ano);
        
        System.out.println(String.format("Em 2030 você terá %d anos", calculo));
        
    }
}
