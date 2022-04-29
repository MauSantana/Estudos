package professor;

/**
 *
 * @author diego <diego.lima@bandtec.com.br>
 */
public class App {
    
    public static void main(String[] args) {
        
        Professor p1 = new Professor(123, "Célia", 6, 250.0);
        Coordenador c1 = new Coordenador(321, "Gerson", 8, 250.0, 6, 200.0, "Pesquisa e Inovação");
        
        System.out.println("\nContratando professor...");
        System.out.println(p1);
        
        System.out.println(String.format("Salario professor %s: %.2f", p1.getNome(), p1.calcularSalario()));
        
        printSeparator();
        
        System.out.println("\nContratando coordenador...");
        System.out.println(c1);
        System.out.println(String.format("Salario coordenador %s: %.2f", c1.getNome(), c1.calcularSalario()));
        
        printSeparator();
        
        System.out.println("\nCriando Escola...");
        Escola escola = new Escola("Colégio Bandeirantes", 2);
        
        System.out.println("Exibindo professores da escola...");
        escola.exibirProfessores();
        
        printSeparator();
        
        System.out.println("Contratando professores...");
        escola.contratarProfessor(p1);
        escola.contratarProfessor(c1);
        
        System.out.println(String.format("\nExibindo professores da escola %s", escola.getNome()));
        escola.exibirProfessores();
        
        printSeparator();
        
        System.out.println("\nCriando outro professor...");
        Professor p2 = new Professor(132, "Yoshi", 10, 250.0);
        
        System.out.println(String.format("Salario professor %s: %.2f", p2.getNome(), p2.calcularSalario()));
        
        System.out.println("Contratando outro professor...");
        escola.contratarProfessor(p2);
        
        printSeparator();
        
        System.out.println("\nExibindo professores...");
        escola.exibirProfessores();
        
        printSeparator();
        
        System.out.println("\nExibindo coordenadores...");
        escola.exibirProfessoresCoordenadores();
        
        printSeparator();
        
        System.out.println("Exibindo dados gerais da escola...");
        System.out.println(escola);
    }
    
    public static void printSeparator(){
        System.out.println("-".repeat(40));
    }
}
