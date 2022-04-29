package aluno;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego <diego.lima@bandtec.com.br>
 */
public class Faculdade {

    private String nome;
    private Integer vagas;
    private List<Aluno> listaAlunos;

    public Faculdade(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.listaAlunos = new ArrayList();
    }

    public void matricularAluno(Aluno aluno) {
        if (listaAlunos.size() < this.vagas) {
            listaAlunos.add(aluno);
        } else {
            System.out.println("Não há vagas nessa instituição.");
        }
    }

    public void exibirAlunosMatriculados() {
        if (!this.listaAlunos.isEmpty()) {
            listaAlunos.forEach(aluno -> System.out.println(aluno));
        } else {
            System.out.println("A instituição não possuí alunos matriculados.");
        }
    }

    public void exibirAlunosPosMatriculados() {

        // Jeito "simplificado" ou "menos elegante" de resolver o solicitado
        // poderia ser facilmente resolvido com "streams"
        // para os entusiastas / curiosos, pesquise vale a pena :)
        Integer alunosPosEncontrados = 0;

        if (!this.listaAlunos.isEmpty()) {
            for (Aluno aluno : listaAlunos) {
                if (aluno instanceof AlunoPos) {
                    System.out.println(aluno);
                    alunosPosEncontrados++;
                }
            }

            if (alunosPosEncontrados == 0) {
                System.out.println("A instituição não possuí alunos de pós-graduação matriculados.");
            }

        } else {
            System.out.println("A instituição não possuí alunos matriculados.");
        }
    }

    public String getNome() {
        return nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    @Override
    public String toString() {
        return "Faculdade: "
                + "\nNome: " + nome
                + "\nVagas: " + vagas
                + "\nVagas disponíveis: " + (vagas - listaAlunos.size())
                + "\nAlunos Matriculados:\n" + listaAlunos;
    }
}
