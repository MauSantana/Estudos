
package br.com.bandtec.lista02;

import java.util.Scanner;


public class Tabuada {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        Integer calculadora = leitor.nextInt();
        
        System.out.println(String.format("Tabuada do %d \n", calculadora));
        for (int i = 0; i < 11; i++) {
            Integer calculo = i * calculadora;
            System.out.println(String.format("%d x %d = %d", calculadora, i, calculo));
        }
    }
}
