
package br.com.bandtec.lista03;

import java.util.Scanner;


public class ClassificaIdade {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite a sua idade: ");
        Integer idade = leitor.nextInt();
        
        classificaIdade(idade);
        
    }
    static void classificaIdade(Integer idade) {
        if (idade >= 0 && idade <=2) {
            System.out.println("Bebê");
        }else if (idade > 2  && idade <=11) {
            System.out.println("Criança");            
        }else if (idade > 11  && idade <=19) {
            System.out.println("Adolescente");
        }else if (idade > 19  && idade <=30) {
            System.out.println("Jovem");
        }else if (idade > 30  && idade <=60) {
            System.out.println("Adulto");
        }else {
            System.out.println("Idoso");
        }
    }
}
