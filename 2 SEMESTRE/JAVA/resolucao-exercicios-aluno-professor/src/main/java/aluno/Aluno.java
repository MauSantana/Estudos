package aluno;

/**
 *
 * @author diego <diego.lima@bandtec.com.br>
 */
public class Aluno {

    protected Integer ra;
    protected String nome;
    protected Double notaContinuada;
    protected Double notaSemestral;

    public Aluno(Integer ra, String nome, Double notaContinuada, Double notaSemestral) {
        this.ra = ra;
        this.nome = nome;
        this.notaContinuada = notaContinuada;
        this.notaSemestral = notaSemestral;
    }

    public Double calculaMedia() {
        return (this.notaContinuada * 0.4) + (this.notaSemestral * 0.6);
    }

    public Integer getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public Double getNotaContinuada() {
        return notaContinuada;
    }

    public Double getNotaSemestral() {
        return notaSemestral;
    }

    @Override
    public String toString() {
        return "\nAluno:"
                + "\nRA: " + ra
                + "\nNome: " + nome
                + "\nnotaContinuada: " + notaContinuada
                + "\nnotaSemestral: " + notaSemestral;
    }
}
