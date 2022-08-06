
package br.com.bandtec.confeitaria;

public class App {
    public static void main(String[] args) {
        
        Bolo bolo1 = new Bolo();
        Bolo bolo2 = new Bolo();
        Bolo bolo3 = new Bolo();
        
        bolo1.sabor = "Morango";
        bolo2.sabor = "Chocolate";
        bolo3.sabor = "Abacaxi";
        

        bolo1.valor = 20.0;
        bolo2.valor = 25.0;
        bolo3.valor = 15.0;
        
        bolo1.comprarBolo(1);
        bolo2.comprarBolo(3);
        bolo3.comprarBolo(2);
               
        bolo1.exibirRelatorio();
        bolo2.exibirRelatorio();
        bolo3.exibirRelatorio();
        
        bolo1.comprarBolo(1);
        bolo2.comprarBolo(3);
        bolo3.comprarBolo(2);
        
        bolo1.exibirRelatorio();
        bolo2.exibirRelatorio();
        bolo3.exibirRelatorio();
        
        bolo1.comprarBolo(1);
        bolo2.comprarBolo(3);
        bolo3.comprarBolo(400);
        
        bolo1.exibirRelatorio();
        bolo2.exibirRelatorio();
        bolo3.exibirRelatorio();
        
    }
}
