
package br.com.bandtec.nivelamento.java2;

import java.util.Scanner;


public class EstruturaRepeticao {
    public static void main(String[] args) {
        
        
        
//        System.out.println("----Exemplo 1: for----");
//        
//        for (int i = 0; i < 10; i++) {
//            System.out.println(String.format("Contador: %d", i));
//        }
//        
//        System.out.println("\n---- Exemplo 2: for ----");
//        
//        for (double i = 10; i >= 0; i-=5) {
//        System.out.println(String.format("Contador: %.2f", i));
//        }
        
        System.out.println("\n---- Exemplo 3: while ----\n");
        
        Scanner leitorNumero = new Scanner(System.in);
        
        System.out.println("Adivinhe o numero: ");
        Integer numero = leitorNumero.nextInt();
        

        while (numero != 42) {
            System.out.println("Numero errado");
            numero = leitorNumero.nextInt();
        }
        System.out.println("Parabens voce acertou");

        
        System.out.println("\n---- Exemplo 4: while ----\n");
        
        numero = 0;
        
        while(numero <=10){
            System.out.println(String.format("contador: %d", numero));
            numero++;
        }
        
        System.out.println("\n---- Exemplo 5: while ----\n");
        
        numero = 10;
        
        while(numero >= 0){
            System.out.println(String.format("contador: %d", numero));
            numero--;
        }
        
        Integer numerao = Integer.MAX_VALUE;
        Integer numerinho = Integer.MIN_VALUE;
        
        System.out.println(numerao);
        System.out.println(numerinho);
        
        System.out.println("\n---- Exemplo 6: dowhile ----\n");
        
        numero = 0;
        
        do {            
            System.out.println("Digite um numero: ");
            numero = leitorNumero.nextInt();
        } while (numero !=42);
        
    }
}
