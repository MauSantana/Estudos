
package br.com.bandtec.nivelamento.java2;

public class OperadoresAritmeticos {
    public static void main(String[] args) {
        String nome = "Chico";
        Double saldo = 200.0;
        
        Double totalPassagens = saldo / 4.40;
                
        System.out.println("Considerando o uso de 4 passagens por dia: " 
                + (totalPassagens.intValue() /4));
        
    }
}
