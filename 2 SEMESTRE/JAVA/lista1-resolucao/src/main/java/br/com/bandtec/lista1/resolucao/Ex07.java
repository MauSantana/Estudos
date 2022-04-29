/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bandtec.lista1.resolucao;

import java.util.Scanner;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class Ex07 {
    
    public static void main(String[] args) {
        
        Scanner leitorTexto = new Scanner(System.in);
        Scanner leitorNumeros = new Scanner(System.in);
        
        System.out.println("Digite o nome de usuário:");
        String nomeDeUsuario = leitorTexto.nextLine();
        
        System.out.println("Digite sua senha:");
        String senha = leitorTexto.nextLine();
        
        System.out.println("Digite a quantidade de tentativas para acertar a senha antes do bloqueio:");
        Integer chances = leitorNumeros.nextInt();
        
        System.out.println(String.format("Seu login é %s.\nVocê tem %d tentativas antes de ser bloqueado",
                nomeDeUsuario, chances));
        
    }
}
