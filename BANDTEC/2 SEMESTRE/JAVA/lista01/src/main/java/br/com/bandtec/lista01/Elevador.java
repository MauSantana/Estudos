
package br.com.bandtec.lista01;

import java.util.Scanner;


public class Elevador {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Qual o limite de peso desse elevador: ");
        Double limitePeso = leitor.nextDouble();
        
        System.out.println("Qual o limite de pessoas desse elevador:");
        Integer limitePessoas = leitor.nextInt();
        
        System.out.println("Qual o peso da 1° pessoa que entrou: ");
        Double pessoa1 = leitor.nextDouble();
        
        System.out.println("Qual o peso da 2° pessoa que entrou: ");
        Double pessoa2 = leitor.nextDouble();
        
        System.out.println("Qual o peso da 3° pessoa que entrou: ");
        Double pessoa3 = leitor.nextDouble();
        
        Double somaPesos = pessoa1 + pessoa2 + pessoa3;
        
        System.out.println(String.format("Entraram 3 pessoas no elevador, "
                + "no qual cabem %d pessoas. O peso total no elevador é de %.2f, sendo que ele suporta %.2f",limitePessoas,somaPesos,limitePeso));
        
    }
}
