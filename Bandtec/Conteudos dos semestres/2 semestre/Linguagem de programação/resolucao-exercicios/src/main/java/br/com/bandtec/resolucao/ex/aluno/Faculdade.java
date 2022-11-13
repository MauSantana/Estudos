package br.com.bandtec.resolucao.ex.aluno;

import java.util.ArrayList;
import java.util.List;

public class Faculdade {

    private String nome;
    private List<Aluno> alunos;

    public Faculdade(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public void matricular(Aluno aluno) {
        aluno.setAtivo(true);
        this.alunos.add(aluno);
    }

    public void exibirAlunos() {
        for (Aluno aluno : alunos) {

//            System.out.println("RA: " + aluno.getRa());
//            System.out.println("Nome: " + aluno.getNome());
//            System.out.println("SEM: " + aluno.getSemestre());
//            System.out.println("Ativo: " + (aluno.isAtivo() ? "Ativo" : "Cancelado"));
            System.out.println(aluno);
        }
    }

    public void cancelarMatricula(String ra) {

        for (int i = 0; i < alunos.size(); i++) {

            Aluno alunoDaVez = alunos.get(i);

            if (alunoDaVez.getRa().equalsIgnoreCase(ra)) {
                alunoDaVez.setAtivo(false);
            }

        }

//        for (Aluno alunoDaVez : alunos) {
//            if (alunoDaVez.getRa().equalsIgnoreCase(ra)) {
//                alunoDaVez.setAtivo(false);
//            }
//        }
    }

    public void exibirAlunosPorSemestre(Integer semestre) {
        for (Aluno aluno : alunos) {
            if (aluno.getSemestre().equals(semestre)) {
                System.out.println(aluno);
            }
        }
    }
    
    public void exibirCancelados(){
        
        for (Aluno aluno : alunos) {
            if (!aluno.isAtivo()) {
                System.out.println(aluno);
            }
        }
    }
}
