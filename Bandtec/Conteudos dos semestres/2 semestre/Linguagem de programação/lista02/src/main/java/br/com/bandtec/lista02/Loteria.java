
package br.com.bandtec.lista02;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Loteria {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite um numero entra 0 e 10: ");
        Integer numero = leitor.nextInt();
        
        Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);
        
        Integer contador = 1;
        
        if (numero.equals(numeroAleatorio)) {
        System.out.println("Você acertou de primeira ! Parabéns\n"
                + "Você é MUITO sortudo\"");     
        }
        while (numero != numeroAleatorio) {            
            System.out.println(String.format("Sorteio:%d    N°Sorteado:%d", contador, numeroAleatorio));
          numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);
          contador ++;
            if (numero.equals(numeroAleatorio) && (contador <= 3)) {
        System.out.println(String.format("\nSeu numero %d demorou %d sorteios para aparecer\n"
                + "Você é MUITO sortudo",numeroAleatorio, contador));

            }else if(numero.equals(numeroAleatorio) && (contador >= 4 && contador <=10)){
              System.out.println(String.format("\nSeu numero %d demorou %d sorteios para aparecer\n"
                + "Você é sortudo",numeroAleatorio, contador));  
            }else if (numero.equals(numeroAleatorio) && (contador >10)){
              System.out.println(String.format("\nSeu numero %d demorou %d sorteios para aparecer\n"
                + "É melhor você parar de apostar e ir trabalhar",numeroAleatorio, contador));  
            }
        }
        
//        if (numero != numeroAleatorio) {
//            for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//            numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);
//        }
//        }
//        
        
    }
}
