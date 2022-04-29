
package br.com.bandtec.lista01;

import java.util.Scanner;

public class SalarioLiquido {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o seu salario bruto: ");
        Double salario = leitor.nextDouble();
        
        Double descontoInss = salario * 0.1;
        Double descontoIr = salario * 0.2;
        
        System.out.println("Quanto custa a condução diária só de ida da casa para o trabalho: ");
        Double conducao = leitor.nextDouble();
        
        Double calculoConducao = (conducao * 2) * 22;
        Double calculoDescontos = (salario - descontoInss) - descontoIr;
        Double salarioLiquido = calculoDescontos - calculoConducao;
        Double todosDescontos = calculoConducao + descontoInss + descontoIr;
        
        System.out.println(String.format("Seu bruto é R$%.2f, "
                + "tem um total de R$%.2f em descontos e receberá um líquido de R$%.2f"
                , salario, todosDescontos, salarioLiquido));
    }
}
