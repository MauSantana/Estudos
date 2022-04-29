
package br.com.bandtec.lista03;

import java.util.Scanner;


public class ClassesSociais {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Informe sua renda: ");
        Double renda = leitor.nextDouble();
        Double salarioMinimo = 1100.00;
        
        Double resultadoSalario = calculoSalario(renda, salarioMinimo);
        
        System.out.println(String.format("Você ganha %.2f salarios minimos\n", resultadoSalario));
        
        verificarClasse(resultadoSalario);
    }
    
    static Double calculoSalario(Double num1, Double num2){
         Double divisao = (num1 / num2);
         return divisao;
    }
    static void verificarClasse(Double teste) {
        if (teste <= 2) {
            System.out.println("Você pertence a classe E");
        }else if (teste > 2 && teste <= 4) {
            System.out.println("Você pertence a classe D"); 
        }else if (teste > 4 && teste <= 10) {
            System.out.println("Você pertence a classe C"); 
        }else if (teste > 10 && teste <= 20) {
            System.out.println("Você pertence a classe B"); 
        }else {
            System.out.println("Você pertence a classe A");
        }
    }
}
