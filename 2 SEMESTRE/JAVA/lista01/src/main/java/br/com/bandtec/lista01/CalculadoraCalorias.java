
package br.com.bandtec.lista01;

import java.util.Scanner;


public class CalculadoraCalorias {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Quanto tempo(minutos) aquecendo: ");
        Integer tempoAquecendo = leitor.nextInt();
        
        System.out.println("Quanto tempo(minutos) fznd exercicio aeróbicos: ");
        Integer tempoExercicioAerobico = leitor.nextInt();
        
        System.out.println("Quanto tempo(minutos) fznd exercicio de musculação: ");
        Integer tempoExercicioMusculacao = leitor.nextInt();
        
        Integer calculo1 = tempoAquecendo * 12;
        Integer calculo2 = tempoExercicioAerobico * 20;
        Integer calculo3 = tempoExercicioMusculacao * 25;
        Integer somaCalorias = calculo1 + calculo2 + calculo3;
        Integer tempoExercicios = tempoAquecendo + tempoExercicioAerobico + 
                tempoExercicioMusculacao;
        
        System.out.println(String.format("Olá, Jorge. Você fez um total de %d "
                + "minutos de exercícios e perdeu cerca de %d calorias", tempoExercicios,
        somaCalorias));
    }
}
