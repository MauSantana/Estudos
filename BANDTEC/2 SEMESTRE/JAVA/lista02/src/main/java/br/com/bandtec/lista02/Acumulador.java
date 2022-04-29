
package br.com.bandtec.lista02;

import java.util.concurrent.ThreadLocalRandom;


public class Acumulador {
    public static void main(String[] args) {
        Integer numero = 0;
        Integer contador = 0;
        Integer rodada =0;
        Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 100);
        do {            
            System.out.println(numeroAleatorio);
            numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 100);
            contador +=numeroAleatorio;
            rodada ++;
        } while (numero !=numeroAleatorio);
        System.out.println(String.format("Parabéns seu"
                + " numero 0 apareceu no sorteio na rodada %d\nE a soma de todos os numeros "
                + "é de: %d"
                ,rodada, contador));
    }
}
