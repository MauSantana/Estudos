
package br.com.bandtec.lista05.clube;


public class ProgramaCampeonato {
    public static void main(String[] args) {
        Clube clube1 = new Clube ("barcelona");
        Clube clube2 = new Clube ("Corinthians");
        
        System.out.println("Começa a temporada!!\n");
        
        clube1.RegistrarVitoria();
        clube2.RegistrarVitoria();
        clube1.RegistrarEmpate();
        clube2.RegistrarVitoria();
        clube1.RegistrarDerrota();
        clube2.RegistrarVitoria();
        
        System.out.println(clube1);
        
        System.out.println(clube2);
    }
}
