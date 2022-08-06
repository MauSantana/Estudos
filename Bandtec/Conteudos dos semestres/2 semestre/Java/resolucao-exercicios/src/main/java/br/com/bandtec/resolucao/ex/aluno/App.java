
package br.com.bandtec.resolucao.ex.aluno;

public class App {
    
    public static void main(String[] args) {
        
        Aluno aluno1 = new Aluno("5000", "Vivian", 3);
        Aluno aluno2 = new Aluno("5001", "Célia", 4);
        Aluno aluno3 = new Aluno("5002", "Gerson", 4);
        Aluno aluno4 = new Aluno("5003", "Frizza", 1);
        
        System.out.println(aluno1);
        System.out.println(aluno2);
        System.out.println(aluno3);
        System.out.println(aluno4);
        
        Faculdade faculdade = new Faculdade("Bandtec - melhor faculdade de tecnologia");
        
        faculdade.matricular(aluno1);
        faculdade.matricular(aluno2);
        faculdade.matricular(aluno3);
        faculdade.matricular(aluno4);
        
        System.out.println("\nExibindo informações de alunos da Faculdade");
        
        faculdade.exibirAlunos();
        
        System.out.println("\nApos cancelamento");
        
        faculdade.cancelarMatricula("5001");
        faculdade.cancelarMatricula("5003");
        
        faculdade.exibirAlunos();
        
        System.out.println("Somente 4º semestre:\n");
        
        faculdade.exibirAlunosPorSemestre(4);
        
        System.out.println("Exibindo somente os cancelados");
        
        faculdade.exibirCancelados();
    }
}
