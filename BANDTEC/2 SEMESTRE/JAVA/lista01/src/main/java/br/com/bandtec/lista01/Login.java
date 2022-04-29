
package br.com.bandtec.lista01;

import java.util.Scanner;


public class Login {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite seu login: ");
        String login = leitor.nextLine();
        
        System.out.println("Digite sua senha: ");
        String senha = leitor.nextLine();
        
        System.out.println("Digite quantas vezes é permitido o erro de senha: ");
        Integer erroSenha = leitor.nextInt();
        
        System.out.println(String.format("Seu login é %s e sua senha é %s."
                + " Você tem %d tentativas antes de ser bloqueado", login, senha,erroSenha));
    }
}
