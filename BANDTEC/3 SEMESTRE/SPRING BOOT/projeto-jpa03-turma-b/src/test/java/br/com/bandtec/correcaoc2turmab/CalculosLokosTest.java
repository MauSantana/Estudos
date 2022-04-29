package br.com.bandtec.correcaoc2turmab;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class CalculosLokosTest {

    final int volume = 5000;

    @Test
    void vaiSemIO() {
        for (int i = 0; i < volume; i++) {
            var n1 = ThreadLocalRandom.current().nextInt(0, volume);
            var n2 = ThreadLocalRandom.current().nextInt(0, volume);

            var resultado = n1 + n2;
        }
    }

    @Test
    void vaiComIO() {
        for (int i = 0; i < volume; i++) {
            var n1 = ThreadLocalRandom.current().nextInt(0, volume);
            var n2 = ThreadLocalRandom.current().nextInt(0, volume);

            System.out.println("n1: "+n1);
            System.out.println("n2: "+n2);

            var resultado = n1 + n2;
            System.out.println("Resultado: "+resultado);
        }
    }

}
