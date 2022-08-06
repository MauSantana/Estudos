
package br.com.bandtec.lista02;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Sorteio {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite um numero entre 1 e 100: ");
        Integer numero = leitor.nextInt();
        
        Integer contador = 0;
        Integer pares = 0;
        Integer impares =0;
        Integer rodadaSorte = 0;
        Integer numeroSorteio = ThreadLocalRandom.current().nextInt(1, 101);
        
        while (contador < 200) {
            System.out.println(String.format("Sorteio: %d   Nº Sorteado:%d",
                    contador, numeroSorteio));
            numeroSorteio = ThreadLocalRandom.current().nextInt(1, 101);
            contador ++;
            if (numero.equals(numeroSorteio)) {
            rodadaSorte = contador;
        
        }if (numeroSorteio % 2 == 0) {
                pares ++;
            }else{
            impares ++;
        }          
        }System.out.println(String.format("Quando o seu numero foi "
            + "sorteado pela 1º vez : %d \n Quantos números pares foram sorteados: "
            + "%d \n Quantos números ímpares foram sorteados: %d", rodadaSorte,
            pares, impares));
    }
}
