import java.util.ArrayList;

public class Aluno {

    // atributos
    private String nome;
    private String ra;
    private String disciplina;
    private Double nota = 0.0;
    private Integer faltas = 0;

    // construtor
    public Aluno(String nome, String ra, String disciplina) {
        this.nome = nome;
        this.ra = ra;
        this.disciplina = disciplina;
    }

    // métodos
    public Integer consultarFaltas() {
        return this.getFaltas();
    }

    public Double consultarNotas() {
        return this.getNota();
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Double getNota() {
        return nota;
    }

    // O lançar nota será chamado no Professor!
    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    // toString
    @Override
    public String toString() {
        return ">> Aluno(a) " + nome + " (" + ra +
                ") de nota " + nota +
                ", com " + faltas +
                " faltas na disciplina de " + disciplina + ".";
    }
}