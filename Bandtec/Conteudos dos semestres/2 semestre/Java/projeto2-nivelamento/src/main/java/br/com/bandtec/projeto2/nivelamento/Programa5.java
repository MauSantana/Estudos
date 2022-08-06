
package br.com.bandtec.projeto2.nivelamento;

import java.util.Scanner;

/*
*
* @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
*/

public class Programa5 {
    
    public static void main(String[] args) {
        
        // Exemplo de como INSTANCIAR um objeto do TIPO Scanner
        Scanner leitorTextos = new Scanner(System.in);
        Scanner leitorNumeros = new Scanner(System.in);
        
        /*
            Para evitar problemas, crie uma instância para capturar textos e
            outra para ler números.
        */
        
        System.out.println("Digite seu nome:");
        // nextline() captura todo o texto
        // comportamento em linha.
        String nome = leitorTextos.nextLine();
        
        // O next() captura somente a primeira palavra
        //String nome = leitor.next();
        
        System.out.println(String.format("\nOlá %s \n", nome));
        
        System.out.println("Qual a sua idade?");
        
        // O nextInt() captura e converte para inteiro o valor digitado
        Integer idade = leitorNumeros.nextInt();
        
        if (idade > 18) {
            System.out.println(String.format("\nVocê tem %d e pode tirar habilitação",
                    idade));
        }else{
            System.out.println(String.format("\nVocê tem %d e não pode tirar habilitação",
                    idade));
        }
        
        System.out.println("\nQuanto custa a passagem de onibus na sua cidade");
        Double precoPassagem = leitorNumeros.nextDouble();
        
        System.out.println(String.format("\nO preço é R$%.2f um pouco salgado =(", precoPassagem));
    }
}
