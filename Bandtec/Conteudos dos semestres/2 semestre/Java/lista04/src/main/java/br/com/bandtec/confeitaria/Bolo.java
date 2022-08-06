
package br.com.bandtec.confeitaria;


public class Bolo {
    
    String sabor;
    Double valor;
    Integer qtdVendida = 0;
    
    void comprarBolo(Integer verificarQtd){
        if (verificarQtd > 100  || verificarQtd < 0 ) {
            System.out.println("Seu pedido ultrapassou nosso limite diário"
                    + " para esse bolo");
        }else {
            qtdVendida += verificarQtd;
        }
    }
    void exibirRelatorio() {
        
        Double calculoVendas =  qtdVendida * valor;
        
        System.out.println(String.format("\nO bolo sabor %s, foi comprado %d vezes hoje,"
                + " totalizando R$ %.2f", sabor, qtdVendida, calculoVendas));
    }
}
