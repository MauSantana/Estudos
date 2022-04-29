
package br.com.bandtec.lista01;

import java.util.Scanner;


public class MediaNotas {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite seu nome: ");
        String nome = leitor.nextLine();
        
        System.out.println("Digite sua primeira nota: ");
        Double nota1 = leitor.nextDouble();
        
        System.out.println("Digite sua segunda nota: ");
        Double nota2 = leitor.nextDouble();
        
        Double media = (nota1 + nota2) / 2;
        
        System.out.println(String.format("Olá, %s. Sua média foi de %.1f", nome, media));
    }
}
