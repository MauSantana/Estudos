
package br.com.bandtec.lista02;

import java.util.Scanner;


public class Votacao {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        
        Integer mussarela = 0;
        Integer calabresa =0;
        Integer quatroQueijos = 0;
        Integer contador = 1;
        
        while (contador <= 10) {            
            System.out.println(String.format("Aluno %d Digite 5, 25 ou 50: "
            , contador));
            Integer valor = leitor.nextInt();
            if (valor != 5 && valor != 25 && valor != 50) {
                System.out.println("numero invalido"); 
            }   else if (valor.equals(5)) {
                mussarela ++;
            }else if (valor.equals(25)){
                calabresa ++;
            }else {
                quatroQueijos ++;
            }
        contador ++;
            
            
        }System.out.println(String.format("Mussarela: %d\n"
                + "Calabresa: %d\n"
                + "Quatro Queijos: %d\n", mussarela, calabresa, quatroQueijos));
}
    }
