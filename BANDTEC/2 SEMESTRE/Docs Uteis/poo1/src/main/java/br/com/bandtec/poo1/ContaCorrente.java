package br.com.bandtec.poo1;

public class ContaCorrente {

    // Atributos -> caracteristicas
    
    /*
        Não existe limitação em termos de quantidade muito menos tipos,
        podemos criar com os tipos que já conhecemos(Integer, Double, String...)
        e muitos outros...
    */
    String titular;
    Double saldo = 0.0;
    
    
    // Métodos -> comportamentos
    
    /*
        Tudo o que vimos sobre métodos vale na criação de nossas
        classes.
        Podemos criar métodos sobrecarregados, com ou sem retorno,
        com ou sem argumentos.
    
        Nesse contexto não se faz necessário o uso da palavra
        reservada 'static', ele serve para um contexto bem específico,
        iremos aprender em breve.
    */
    void depositar(Double valor) {
        saldo += valor;
    }
    
    void sacar(Double valor){
        Double resultado = saldo-valor;
        saldo=resultado;
    }
}
