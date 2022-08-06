package professor;

/**
 *
 * @author diego <diego.lima@bandtec.com.br>
 */
public class Coordenador extends Professor {

    private Integer qtdHorasCoord;
    private Double valorHoraCoord;
    private String curso;

    public Coordenador(Integer codigo, String nome, Integer horas, Double valorHora, Integer qtdHorasCoord, Double valorHoraCoord, String curso) {
        super(codigo, nome, horas, valorHora);
        this.qtdHorasCoord = qtdHorasCoord;
        this.valorHoraCoord = valorHoraCoord;
        this.curso = curso;
    }

    @Override
    public Double calcularSalario() {
        return super.calcularSalario() + ((this.qtdHorasCoord * this.valorHoraCoord) * 4.5);
    }

    public Integer getQtdHorasCoord() {
        return qtdHorasCoord;
    }

    public Double getValorHoraCoord() {
        return valorHoraCoord;
    }

    public String getCurso() {
        return curso;
    }

    public void setQtdHorasCoord(Integer qtdHorasCoord) {
        this.qtdHorasCoord = qtdHorasCoord;
    }

    public void setValorHoraCoord(Double valorHoraCoord) {
        this.valorHoraCoord = valorHoraCoord;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "\nCoordenador:\n" 
                + super.toString()
                + "qtdHorasCoord: " + qtdHorasCoord 
                + "\nvalorHoraCoord: " + valorHoraCoord 
                + "\ncurso: " + curso;
    }
}
