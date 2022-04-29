
package br.com.bandtec.nivelamento.java2;

import java.util.Scanner;


public class EstruturaSelecao {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
//        System.out.println("Digite um numero de 1 a 7");
//        Integer numeroDigitado = leitorNumero.nextInt();
//        
//        switch (numeroDigitado) {
//            case 1:
//                System.out.println("Domingo");
//                break;
//            case 2:
//                System.out.println("Segunda");
//                break;
//            case 3:
//                System.out.println("Terça");
//                break;
//            case 4:
//                System.out.println("Quarta");
//                break;
//            case 5:
//                System.out.println("Quinta");
//                break;
//            case 6:
//                System.out.println("Sexta");
//                break;
//            case 7:
//                System.out.println("Sabado");
//                break;
//            default:
//                System.out.println("Numero Invalido");
//                break;
//        }

//        System.out.println("Digite um nome");
//        String nomeDigitado = leitor.nextLine();
//        
//        switch(nomeDigitado) {
//            case "Frizza":
//                System.out.println("Upalala");
//                break;
//            case "Gerson":
//                System.out.println("Saudações");
//                break;
//            case "Yoshi":
//                System.out.println("Tomaaaaaaaa");
//                break;
//            default:
//                System.out.println("Prof não encontrado");
//                break;
//        }

                System.out.println("Digite o ranking");
        Integer numero = leitor.nextInt();
        
        switch(numero) {
            case 1:
                System.out.println("Iphone");

            case 2:
                System.out.println("Android");

            case 3:
                System.out.println("Chaveiro");
                break;
            default:
                System.out.println("não ganhou");
                break;
        }
}
}
