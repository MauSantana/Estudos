package br.com.bandtec.lista02.resolucao;

import java.util.Scanner;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class Tabuada {

    public static void main(String[] args) {

        Scanner leitorNumero = new Scanner(System.in);

        System.out.println("Digite um número:");
        Integer numero = leitorNumero.nextInt();

        for (Integer i = 0; i <= 10; i++) {
            System.out.println(String.format("%d X %d = %d",
                    numero,
                    i,
                    (numero * i)));
        }

    }
}
