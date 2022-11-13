
package aluno;

/**
 *
 * @author diego <diego.lima@bandtec.com.br>
 */
public class AlunoPos extends Aluno {

    private Double notaMonografia;

    public AlunoPos(Integer ra, String nome, Double notaContinuada, Double notaSemestral, Double notaMonografia) {
        super(ra, nome, notaContinuada, notaSemestral);
        this.notaMonografia = notaMonografia;
    }

    @Override
    public Double calculaMedia() {
        return (this.notaContinuada + this.notaSemestral + this.notaMonografia) / 3;
    }

    public Double getNotaMonografia() {
        return notaMonografia;
    }

    @Override
    public String toString() {
        return "\nAlunoPos:" + 
                super.toString() + 
                "\nNota Monografia: " + notaMonografia;
    }

}
