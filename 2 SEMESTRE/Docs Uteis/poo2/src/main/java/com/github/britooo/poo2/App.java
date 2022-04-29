
package com.github.britooo.poo2;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class App {
    
    public static void main(String[] args) {
        
        ContaCorrente conta1 = new ContaCorrente();
        ContaCorrente conta2 = new ContaCorrente();
        
        conta1.setCliente("Diego Brito");
        
        System.out.println(String.format("Cliente: %s", conta1.getCliente()));

        conta1.setCliente("Matheus");
        
        System.out.println(String.format("Cliente: %s", conta1.getCliente()));
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
