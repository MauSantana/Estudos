
package aluno;

/**
 *
 * @author diego <diego.lima@bandtec.com.br>
 */
public class App {
    
    public static void main(String[] args) {
     
        //Criação dos objetos do tipo Aluno e AlunoPos
        Aluno a1 = new Aluno(5000, "Diego", 8.4, 9.2);
        AlunoPos p1 = new AlunoPos(5100, "Célia", 10.0, 9.5, 7.4);
        
        //Exibindo a média de cada um:
        System.out.println(String.format("Aluno %s tem média: %.2f", a1.getNome(), a1.calculaMedia()));
        System.out.println(String.format("Aluno de pós %s tem média: %.2f", p1.getNome(), p1.calculaMedia()));
        
        System.out.println("Criando faculdade...");
        Faculdade faculdade = new Faculdade("Bandtec", 2);
        
        //Invocando método com a lista vazia:
        System.out.println("Exibindo alunos matriculados...");
        faculdade.exibirAlunosMatriculados();
        
        System.out.println("\nMatriculando 2 alunos...");
        faculdade.matricularAluno(a1);
        faculdade.matricularAluno(p1);
        
        //Excedendo o limite de vagas:
        System.out.println("\nCriando 3 aluno....");
        Aluno a2 = new Aluno(5002, "Caio", 8.9, 9.2);
        System.out.println("Matriculando 3º aluno...");
        faculdade.matricularAluno(a2);
        
        System.out.println("\nExibindo todos os alunos matriculados...");
        faculdade.exibirAlunosMatriculados();

        System.out.println("\nExibindo todos os alunos de pós-graduação matriculados...");
        faculdade.exibirAlunosPosMatriculados();
        
        System.out.println("\nExibindo dados gerais da faculdade...");
        System.out.println(faculdade);
        
    }
}
