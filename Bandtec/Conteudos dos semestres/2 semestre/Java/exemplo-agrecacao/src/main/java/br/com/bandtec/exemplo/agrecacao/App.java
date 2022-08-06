
package br.com.bandtec.exemplo.agrecacao;

public class App {
    public static void main(String[] args) {
        
        Contato c1 = new Contato ("Mau Santana", "11953843747");
        Contato c2 = new Contato ("dieguinho", "1195872747");
        
        Grupo professoresBandtec = new Grupo ("professores Bandtec");
        Grupo zoeira = new Grupo ("professores Bandtec");
        
        professoresBandtec.adiciona(c1);
        professoresBandtec.adiciona(c2);
        
        System.out.println(professoresBandtec);
        
        professoresBandtec.remove(c1);
        
        zoeira.adiciona(c1);
        
        System.out.println("");
        System.out.println(zoeira);


    }
}
