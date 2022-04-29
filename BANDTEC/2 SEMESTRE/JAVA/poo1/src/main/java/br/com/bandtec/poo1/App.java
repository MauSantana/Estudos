
package br.com.bandtec.poo1;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
// Até agora se tivessemos que programar algo que representasse uma 
// conta conrrente seria algo mais ou menos assim;
        
//        String titular1 = "Diego";
//        String titular2 = "Giuliana";
//        
//        Double saldo1 = 34.65;
//        Double saldo2 = 34.65;

        // Exemplo de instância -> um objeto criado a partir de uma forma
//        Scanner teste = new Scanner(System.in);
        
        ContaCorrente conta1 = new ContaCorrente();
        ContaCorrente conta2 = new ContaCorrente();
        
        conta1.titular = "Mauricio";
        conta1.saldo = 5000.0;
        
        conta2.titular = "Neymar";
        conta2.saldo = 1000.0;
        
        conta1.depositar(5000.0);
        
        System.out.println("Conta 1");
        System.out.println(conta1.titular);
        System.out.println(conta1.saldo);
        
        
        System.out.println("Conta 2");
        System.out.println(conta2.titular);
        System.out.println(conta2.saldo);
        
        conta1.depositar(5000.0);
        
        System.out.println("Conta 1");
        System.out.println(conta1.titular);
        System.out.println(conta1.saldo);       
//        System.out.println("Conta 1");
//        System.out.println(conta1.titular);
//        System.out.println(conta1.saldo); 

        conta1.sacar(49.80);
        System.out.println("\nConta 1");
        System.out.println(conta1.titular);
        System.out.println(conta1.saldo);  

    
    }
}
