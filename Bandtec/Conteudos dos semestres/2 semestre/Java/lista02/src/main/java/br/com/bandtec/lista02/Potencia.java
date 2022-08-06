
package br.com.bandtec.lista02;

import java.util.Scanner;


public class Potencia {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o valor base: ");
        Integer base = leitor.nextInt();
        Integer resultado = base;
        System.out.println("Digite o valor expoente: ");
        Integer expoente = leitor.nextInt();
        
        Integer contador =1;
        
        while (contador < expoente ) {
            resultado *= base;

            System.out.println(resultado);
            contador++;

            
        }

    }
}
