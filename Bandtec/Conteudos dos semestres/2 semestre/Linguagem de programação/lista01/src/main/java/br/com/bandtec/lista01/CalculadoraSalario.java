

package br.com.bandtec.lista01;

import java.util.Scanner;


public class CalculadoraSalario {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite seu salário: ");
        Double salario = leitor.nextDouble();
        
        System.out.println("Digite a porcentagem de imposto a ser paga: ");
        Double imposto = leitor.nextDouble();
        
        Double calculo = imposto/100;
        Double calculo2 = salario * calculo;
        Double calculo3 = salario - calculo2;
        
        System.out.println(String.format("O seu salário liquido é de %.2f", calculo3));
    }
}
