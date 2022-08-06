
package br.com.bandtec.nivelamento.java2;

import java.util.Scanner;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class ProblemasScanner {
    
    public static void main(String[] args) {

        Scanner leitorNumero = new Scanner(System.in);
        
        // Criação de outro objeto leitor apenas para ler com nextLine()
        Scanner leitorTexto = new Scanner(System.in);
        
        String nome;
        Integer num1;
        Integer num2;
        Integer num3;
        
        // Quando usamos nextInt() ou nextDouble() ou next() para ler alguma coisa
        // e em seguida usamos o nextLine() para ler um texto
        // Acontece um problema: A execução do programa não para para digitarmos o texto
        // que deveria ser lido pelo nextLine()
        // Isso acontece pq o nextLine() consome o <Enter> que foi digitado na leitura 
        // anterior e lê uma String vazia
        System.out.println("Digite um número inteiro");
        num1 = leitorNumero.nextInt();
        
        System.out.println("Digite seu nome");
        nome = leitorTexto.nextLine();
        
        System.out.println("Digite outro número inteiro");
        num2 = leitorNumero.nextInt();
        
        System.out.println(String.format("olá %s %d %d", nome, num1, num2));
        
        System.out.println("Digite 3 números");
        num1 = leitorNumero.nextInt();
        num2 = leitorNumero.nextInt();
        num3 = leitorNumero.nextInt();
        
        System.out.println("Digite o nome de 3 frutas");
        String fruta1 = leitorTexto.next();
        String fruta2 = leitorTexto.next();
        String fruta3 = leitorTexto.next();
        
        System.out.println(String.format("num1= %d\nnum2= %d\nnum3= %d",
                           num1, num2, num3));
        
        System.out.println(String.format("fruta1= %s\nfruta2= %s\nfruta3= %s",
                           fruta1, fruta2, fruta3));
    }
}
