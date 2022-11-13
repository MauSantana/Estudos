package br.com.bandtec.lista01;

import java.util.Scanner;

public class BolsaFilhos {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite quantos filhos de 0 a 3 anos você possui: ");
        Integer filhos1 = leitor.nextInt();
        System.out.println("Digite quantos filhos de 4 a 16 anos você possui: ");
        Integer filhos2 = leitor.nextInt();
        System.out.println("Digite quantos filhos de 17 a 18 anos você possui: ");
        Integer filhos3 = leitor.nextInt();
        
        Double calculo1 = filhos1 * 25.12;
        Double calculo2 = filhos2* 15.88;
        Double calculo3 = filhos3* 15.88;
        
        Double calculoTotal = calculo1 + calculo2 + calculo3;
        Integer totalFilhos = filhos1 + filhos2 + filhos3;
        
        System.out.println(String.format("Você tem um total"
                + " de %d filhos e vai receber R$%.2f de bolsa", totalFilhos, calculoTotal));
    }
}