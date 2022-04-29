
package br.com.bandtec.nivelamento.java3;

import java.util.Scanner;


public class Exemplo2 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Informe sua primeira nota: ");
        Double nota1 = leitor.nextDouble();
        
        System.out.println("Informe sua primeira nota: ");
        Double nota2 = leitor.nextDouble();
        
        System.out.println("Informe sua terceira nota: ");
        Double nota3 = leitor.nextDouble();
        
        Double resultado = calculo(nota1,nota2,nota3);
        
        exibeMedia(resultado);
    }
        // Exemplo do conceito de sobrecarga de método:
    // Podemos criar um método com o mesmo nome mas que receba parametros diferentes
    // e em tempo de execução o Java sabe qual método se trata baseado no tipo e na quantidade
    // de argumentos informados.
    static Double calculo(Double nota1, Double nota2){
        Double media = (nota1 + nota2) / 2;
        return media;
    }
    static Double calculo(Double nota1, Double nota2, Double nota3){
        Double media = (nota1 + nota2 + nota3) / 3;
        return media;
    }
    static void exibeMedia(Double mediaAluno) {
        if (mediaAluno >= 6) {
            System.out.println(String.format("%.2f aprovado", mediaAluno));
        }else {
            System.out.println(String.format("%.2f reprovado", mediaAluno));
        }
    }
}
