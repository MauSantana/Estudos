
package br.com.bandtec.nivelamento.java2;

import java.util.concurrent.ThreadLocalRandom;


public class NumerosAleatorios {
    
    public static void main(String[] args) {
        System.out.println("Exemplo 1 \n");
        Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 101);
        for (int i = 0; i < 10; i++) {
            System.out.println(numeroAleatorio);
            numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 101);
        }
        
        
        System.out.println("Exemplo 2 \n");
        Double numeroGerado = ThreadLocalRandom.current().nextDouble(0, 100);
        for (int i = 0; i < 10; i++) {
            System.out.println(numeroGerado);
            numeroGerado = ThreadLocalRandom.current().nextDouble(0, 100);
        }
    }
}
