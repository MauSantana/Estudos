package br.com.bandtec.lista02.resolucao;

import java.util.Scanner;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class Login {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        // Simulando dados que vieram de um BD....
        String usuario = "admin";
        String senha = "#Bandtec";

        System.out.println("Digite o usuário:");
        String usuarioDigitado = leitor.nextLine();

        System.out.println("Digite a senha:");
        String senhaDigitada = leitor.nextLine();

        Boolean estaCorreto = usuario.equals(usuarioDigitado) && senha.equals(senhaDigitada);

        while (!estaCorreto) {
            System.out.println("\nUsuário e/ou Senha incorretos.");
            System.out.println("Tente novamente.\n");

            System.out.println("Digite o usuário:");
            usuarioDigitado = leitor.nextLine();

            System.out.println("Digite a senha:");
            senhaDigitada = leitor.nextLine();

            estaCorreto = usuario.equals(usuarioDigitado) && senha.equals(senhaDigitada);
        }

        System.out.println("Login realizado com sucesso!");
    }
}
