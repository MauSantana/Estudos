
package br.com.bandtec.lista01;

import java.util.Scanner;

public class CalculadoraTroco {
    
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o valor do produto: ");
        Double valorProduto = leitor.nextDouble();
        
        System.out.println("Digite a quantidade de produtos vendidos: ");
        Integer quantProduto = leitor.nextInt();
        
        System.out.println("Digite o valor pago pelo cliente: ");
        Double pgmtProduto = leitor.nextDouble();
        
        Double calculoTroco1 = quantProduto * valorProduto;
        Double calculoTroco2 = pgmtProduto - calculoTroco1;

        System.out.println(String.format("Seu troco será de R$ %.2f", calculoTroco2));
    }
}
