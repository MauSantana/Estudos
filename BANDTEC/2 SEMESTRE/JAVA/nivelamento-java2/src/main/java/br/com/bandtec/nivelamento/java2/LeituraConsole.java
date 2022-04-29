
package br.com.bandtec.nivelamento.java2;

import java.util.Scanner;

public class LeituraConsole {
   
    public static void main(String[] args) {
        
        //Exemplo de instancia ou populamento de objeto
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNumero = new Scanner(System.in);
        System.out.println("Escreva seu nome:");
        
        String nome = leitor.nextLine();
        
        System.out.println(String.format("Olá %s", nome));
        
        System.out.println("Escreva sua idade:");
        Integer idade = leitorNumero.nextInt();
        
        System.out.println(String.format("Você nasceu em %d", 2021-idade));
    }
}
