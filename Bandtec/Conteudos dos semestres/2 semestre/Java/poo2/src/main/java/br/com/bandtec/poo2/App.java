
package br.com.bandtec.poo2;

public class App {
    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente();
        
        conta1.depositar50();
        conta1.depositar50();
        conta1.depositar50();
        conta1.depositar50();
        conta1.depositar50();
        
        System.out.println(String.format("Saldo: R$%.2f", conta1.getSaldo()));
        
        conta1.sacar50();
        conta1.sacar50();
        conta1.sacar50();
        conta1.sacar50();
        conta1.sacar50();
        
        System.out.println(String.format("Saldo: R$%.2f", conta1.getSaldo()));
        
    }
}
