
package br.com.bandtec.lista03;

import java.util.Scanner;


public class DescontoProgressivo {
    public static void main(String[] args) {
        Scanner leitor = new Scanner (System.in);

        System.out.println("Digite o valor(unitário) do produto): ");
        Double produto = leitor.nextDouble();
                
        System.out.println("Digite a quantidade de produtos: ");
        Integer qtdProduto = leitor.nextInt();
        
        exibirNotaFiscal(produto, qtdProduto);
        Double resultado = exibirNotaFiscal(produto, qtdProduto);
        calcularDesconto(resultado, qtdProduto);

    }
    static void calcularDesconto(Double num1, Integer num2) {
        if (num2.equals(1)) {
            Double resultado = num1 * 0.9;
            System.out.println(String.format("Valor com desconto: %.2f", resultado));
        }else if (num2.equals(2)){
            Double resultado = num1 * 0.8;
            System.out.println(String.format("Valor com desconto: %.2f", resultado));
        }else {
            Double resultado = num1 * 0.7;
            System.out.println(String.format("Valor com desconto: %.2f", resultado));
        }
    }
    static Double exibirNotaFiscal (Double num1, Integer num2){
        Double multiplicacao = num1 * num2;
        return multiplicacao;
    }
}
