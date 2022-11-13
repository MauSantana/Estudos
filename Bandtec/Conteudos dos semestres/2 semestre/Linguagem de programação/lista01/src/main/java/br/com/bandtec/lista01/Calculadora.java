
package br.com.bandtec.lista01;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        Double num1 = leitor.nextDouble();
        
        System.out.println("Digite outro numero: ");       
        Double num2 = leitor.nextDouble();
        
        System.out.println(String.format("Resultado da soma: %.2f", num1+num2));
        System.out.println(String.format("Resultado da subtração: %.2f", num1-num2));
        System.out.println(String.format("Resultado da multiplicação: %.2f", num1*num2));
        System.out.println(String.format("Resultado da divisão: %.2f", num1/num2));
    }
}
