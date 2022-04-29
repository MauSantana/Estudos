import java.util.ArrayList;

public class Professor {

    // atributos
    protected String nome;
    protected String disciplina;
    protected ArrayList<Aluno> meusAlunos = new ArrayList<>();

    // construtor
    public Professor(String nome, String disciplina) {
        this.nome = nome;
        this.disciplina = disciplina;
    }

    // métodos
    public void lancarNota(Aluno aluno, Double nota) {
        if (aluno.getDisciplina() == this.disciplina) {
            aluno.setNota(nota);
            System.out.println(". . . " + nota + " nota lançada pelo professor "+
                    this.nome+" ao aluno " + aluno.getNome() + ". . .");
        } else {
            System.out.println("\tERROR: Voce nao pode lançar notas para este aluno(a) ("+aluno.getNome()+
                    ") pois ele(a) é aluno(a) de \'"+  aluno.getDisciplina()+
                    "\' e você é professor de \'"+this.disciplina+"\'");
        }

    }

    public void lancarFaltas(Aluno aluno, Integer falta) {
        if (aluno.getDisciplina() == this.disciplina) {
            aluno.setFaltas(aluno.getFaltas() + falta);
            System.out.println(". . . " + falta + " falta(s) lançada(s) pelo professor "+
                    this.nome+" ao aluno " + aluno.getNome() + ". . .");
        } else {
            System.out.println("\tERROR: Voce não pode lançar faltas para este aluno ("+aluno.getNome()+
                    ") pois ele(a) é aluno(a) de <"+  aluno.getDisciplina()+
                    "> e você é professor de <"+this.disciplina+">.");
        }
    }

    public void addAluno(Aluno aluno) {
        this.meusAlunos.add(aluno);
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public ArrayList<Aluno> getMeusAlunos() {
        return meusAlunos;
    }

    // em vez de usar setMeusAlunos, como esta, usaremos addAluno
    public void setMeusAlunos(ArrayList<Aluno> meusAlunos) {
        this.meusAlunos = meusAlunos;
    }

    // toString
    @Override
    public String toString() {
        ArrayList<String> meusAlunosStr = new ArrayList<>();
        for (Aluno alu:meusAlunos) {
            meusAlunosStr.add(alu.getNome());
        }
        return "Professor {" +
                "nome='" + nome + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", meusAlunos=" + meusAlunosStr +
                '}';
    }
}
