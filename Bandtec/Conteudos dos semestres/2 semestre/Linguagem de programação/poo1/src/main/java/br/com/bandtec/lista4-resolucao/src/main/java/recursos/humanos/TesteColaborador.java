
package recursos.humanos;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class TesteColaborador {
    
    public static void main(String[] args) {
        Colaborador colaborador1 = new Colaborador("Diego Brito", "Desenvolvedor Junior", 4000.0);
        Colaborador colaborador2 = new Colaborador("Giuliana Miniguiti", "Analista", 6000.0);
        
        RecursosHumanos rh = new RecursosHumanos();
        
        rh.reajustarSalario(colaborador1, 10.0);
        
        System.out.println(colaborador1);
        
        rh.promoverColaborador(colaborador1, "Desenvolvedor Pleno", 5600.0);
        
        System.out.println(colaborador1);

        rh.reajustarSalario(colaborador2, 15.0);
        
        System.out.println(colaborador2);
        
        rh.promoverColaborador(colaborador2, "Analista pleno", 5600.0);
        
        System.out.println(colaborador2);
        
        System.out.println(rh);
    }
}
