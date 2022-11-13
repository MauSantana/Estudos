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
public class Ex09 {

    public static void main(String[] args) {
        
        Scanner leitorNumero = new Scanner(System.in);

        System.out.println("Valor do salário bruto:");
        Double salarioBruto = leitorNumero.nextDouble();

        System.out.println("Condução diária (somente ida):");
        Double conducao = leitorNumero.nextDouble();

        Double descontoINSS = salarioBruto * 0.1;
        Double descontoIR = salarioBruto * 0.2;
        Double descontoVT = (conducao * 2) * 22;

        Double salarioLiquido = salarioBruto - descontoINSS - descontoIR - descontoVT;

        System.out.println("-".repeat(10) + "FOLHA DE PAGAMENTO" + "-".repeat(10));
        System.out.println(String.format("\nSalário bruto:\tR$%.2f", salarioBruto));
        System.out.println(String.format("Desconto INSS:\tR$%.2f", descontoINSS));
        System.out.println(String.format("Desconto IR:\tR$%.2f", descontoIR));
        System.out.println(String.format("Desconto VT:\tR$%.2f\n", descontoVT));
        System.out.println("-".repeat(38));
        System.out.println(String.format("\nSalário líquido:\tR$%.2f\n", salarioLiquido));
    }
}
