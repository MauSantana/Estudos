
package br.com.bandtec.lista02;

import java.util.Scanner;


public class Login {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite seu usuario: ");
        String usuario = leitor.nextLine();
        
        System.out.println("Digite sua senha: ");
        String senha = leitor.nextLine();
        
        if (usuario.equals("admin") && senha.equals("#Bandtec")) {
            System.out.println("Login realizado com sucesso");
        }else {
        while (usuario != "admin" || senha !="#Bandtec") { 
            System.out.println("Login e/ou senha inválidos");
            System.out.println("Digite seu usuario: ");
            usuario = leitor.nextLine();
            System.out.println("Digite sua senha: ");
            senha = leitor.nextLine();
//            if (usuario.equals("admin") && senha.equals("#Bandtec")) {
//            System.out.println("Login realizado com sucesso");
        }
        }
        }
    }
