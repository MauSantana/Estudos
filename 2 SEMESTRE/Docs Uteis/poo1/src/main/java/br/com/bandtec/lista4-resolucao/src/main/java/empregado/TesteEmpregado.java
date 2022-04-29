
package empregado;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class TesteEmpregado {
    
    public static void main(String[] args) {
        
        Empregado empregado1 = new Empregado("João", "Analista de Sistemas", 5400.0);
        
        empregado1.reajustarSalario(15.0);
        
        System.out.println(empregado1);
        
        System.out.println("");
        
        Empregado empregado2 = new Empregado("Diego Brito", "Professor", 4000.0);
        
        empregado2.reajustarSalario(10.0);
        
        System.out.println(empregado2);
        
        
        
    }
}
