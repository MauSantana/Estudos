
package br.com.bandtec.poo1;


public class ContaCorrente {
    // Atributo -> caracteristica
    Double saldo = 0.0;
    String titular;
    
    void depositar(Double quantia){
        saldo+= quantia;
    }
    
    void sacar (Double quantia){
        saldo-= quantia;
    }
    
}
