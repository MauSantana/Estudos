package br.com.bandtec.exercicios.semelhantes.transportadora;

public class App {

    public static void main(String[] args) {

        Encomenda e1 = new Encomenda(
                10.00,
                20.00,
                "Rua Haddock Lobo 595, Cerqueira cesar, SP",
                "R. do Tatuapé, 265 - Maranhão, SP",
                5.00, 45.00);

        Transportadora t = new Transportadora("Miniguiti");
        
        System.out.println("\nENVIANDO 1º ENCOMENDA\n");
        t.enviar(e1);
        
        System.out.println("\nTENTANDO REENVIAR 1º ENCOMENDA\n");
        t.enviar(e1);

        System.out.println(t);

    }
}
