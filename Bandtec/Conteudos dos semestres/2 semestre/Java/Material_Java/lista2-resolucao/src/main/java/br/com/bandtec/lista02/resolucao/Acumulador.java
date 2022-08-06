package br.com.bandtec.lista02.resolucao;

import java.util.Scanner;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class Acumulador {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Integer valorDigitado;
        Integer total = 0;

        do {

            System.out.println("Digite um número:");

            valorDigitado = leitor.nextInt();

            total += valorDigitado;

        } while (!(valorDigitado.equals(0)));

        System.out.println(String.format("Total acumulado: %d", total));
    }
}
