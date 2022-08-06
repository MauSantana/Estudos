
package br.com.bandtec.lista05.clube.calculadora;


public class ProgramaCalculo {
    public static void main(String[] args) {
        Calculadora calculadora1 = new Calculadora();
        Calculadora calculadora2 = new Calculadora();
        
        System.out.println("Iniciando Programa Calculadora\n");
        
        calculadora1.realizarSoma(5.0, 2.0);
        calculadora1.realizarSubtracao(5.0, 2.0);
        calculadora1.realizarMultiplicacao(5.0, 2.0);
        calculadora1.realizarDivisao(5.0, 2.0);
        
        System.out.println("Programa encerrado\n");
        System.out.println("---------------------------\n");
        
        
        
        System.out.println("Iniciando Programa Calculadora\n");
        
        calculadora2.realizarSoma(7.5, 5.0);
        calculadora2.realizarSubtracao(7.5, 5.0);
        calculadora2.realizarMultiplicacao(7.5, 5.0);
        calculadora2.realizarDivisao(7.5, 5.0);
        
        System.out.println("\nPrograma encerrado\n");

    }
}
