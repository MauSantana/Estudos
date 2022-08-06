package br.com.bandtec.resolucao.ex.aluno;

public class Aluno {

    private String ra;
    private String nome;
    private Integer semestre;
    private Boolean ativo;

    public Aluno(String ra, String nome, Integer semestre) {
        this.ra = ra;
        this.nome = nome;
        this.semestre = semestre;
        this.ativo = false;
    }

    public Aluno(String ra, String nome, Integer semestre, Boolean ativo) {
        this.ra = ra;
        this.nome = nome;
        this.semestre = semestre;
        this.ativo = ativo;
    }

    public String getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return String.format("\nRA: %s\nNome: %s\nSem: %d\nAtivo: %s\n",
                this.ra,
                this.nome,
                this.semestre,
                (this.ativo ? "Ativo" : "Cancelado")
        );
    }
}
