
package exercicio01;

import java.util.ArrayList;
import java.util.List;

public class Faculdade {
    private String nome;
    private List<Aluno> alunos;

    public Faculdade(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList();
    }
    
    public void matricularAluno(Aluno aluno){
        aluno.setAtivo(true);
        this.alunos.add(aluno);
    }
    
    public void exibirAluno(){
        for (Aluno aluno : alunos) {
//            System.out.println("Nome: "+ aluno.getNome());
            
            System.out.println(aluno);
        }
    }
    
}
