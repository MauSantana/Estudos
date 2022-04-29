package br.com.bandtec.nivelamento.java3;

import java.util.Scanner;

public class Exemplo1 {

    public static void main(String[] args) {

        System.out.println("Diego");
        
        //Exemplo de utilização de um método sem argumentos e sem retorno
        exibeLinha();

        System.out.println("Brito");

        exibeLinha();

        System.out.println("Hello world");

        exibeLinha();

        Integer numero1 = 2;
        Integer numero2 = 3;
        
        //Exemplo de como utilizar método com retorno
        //Note que é importante "capturar o retorno e guardar numa variavel do mesmo tipo"
        Integer resultado1 = somar(numero1, numero2);
        System.out.println("Resulado da soma 1 : " + resultado1);
        
        Integer resultado2 = somar(10, 10);
        System.out.println("Resulado da soma 2 : " + resultado2);
        
        Scanner leitorTexto = new Scanner(System.in);
        
        System.out.println("Digite seu nome:");
        String nome = leitorTexto.nextLine();
        
        exibirNome(nome);
        
    }
    
    // Exemplo de método com argumentos, sem retorno que além de executar algo,
    // invoca outro método
    static void exibirNome(String nome){
        exibeLinha();
        System.out.println(nome);
        exibeLinha();
    }
    
    // Exemplo de método sem retorno e sem argumentos
    static void exibeLinha() {
        System.out.println("****************************");
    }
    
    //Exempllo de método com argumentos sem retorno
//    static void somar(Integer num1, Integer num2) {
//        System.out.println(num1 + num2);
//    }
    
    // Exemplo de método com argumentos e com retorno
    static Integer somar(Integer num1, Integer num2) {
        return num1 + num2;
    }
}
