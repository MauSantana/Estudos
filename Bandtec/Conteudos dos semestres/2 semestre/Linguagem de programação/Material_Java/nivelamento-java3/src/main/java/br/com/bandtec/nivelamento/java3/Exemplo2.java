package br.com.bandtec.nivelamento.java3;

import java.util.Scanner;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class Exemplo2 {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite a primeira nota:");
        Double nota1 = leitor.nextDouble();

        System.out.println("Digite a segunda nota:");
        Double nota2 = leitor.nextDouble();

        Double resultado = calculaMedia(nota1, nota2);
        exibeSituacaoAluno(resultado);
        
        System.out.println("Digite a primeira nota:");
        Double notaP1 = leitor.nextDouble();

        System.out.println("Digite a segunda nota:");
        Double notaP2 = leitor.nextDouble();
        
        System.out.println("Digite a terceira nota:");
        Double notaP3 = leitor.nextDouble();

        Double resultado2 = calculaMedia(notaP1, notaP2, notaP3);        
        exibeSituacaoAluno(resultado2);

    }
    
    // Exemplo do conceito de sobrecarga de método:
    // Podemos criar um método com o mesmo nome mas que receba parametros diferentes
    // e em tempo de execução o Java sabe qual método se trata baseado no tipo e na quantidade
    // de argumentos informados.
    static Double calculaMedia(Double notaAc1, Double notaAc2) {
        Double media = (notaAc1 + notaAc2) / 2;
        return media;
    }
    
    static Double calculaMedia(Double notaAc1, Double notaAc2, Double notaAc3) {
        Double media = (notaAc1 + notaAc2 + notaAc3) / 3;
        return media;
    }

    static void exibeSituacaoAluno(Double mediaDoAluno) {
        if (mediaDoAluno >= 6) {
            System.out.println(String.format("%.2f aprovado", mediaDoAluno));
        } else {
            System.out.println(String.format("%.2f reprovado", mediaDoAluno));
        }

    }
}
