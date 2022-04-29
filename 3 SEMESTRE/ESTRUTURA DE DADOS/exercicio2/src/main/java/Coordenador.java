public class Coordenador extends Funcionario{

private Integer qtdHoraCoordenacao;
private Double valorHoraCoordenacao;

    public Coordenador(String nome, Integer qtdHoraAula, Double valorHoraAula,
                       Integer qtdHoraCoordenacao, Double valorHoraCoordenacao) {
        super(nome, qtdHoraAula, valorHoraAula);
        this.qtdHoraCoordenacao = qtdHoraCoordenacao;
        this.valorHoraCoordenacao = valorHoraCoordenacao;
    }

    public Integer getQtdHoraCoordenacao() {
        return qtdHoraCoordenacao;
    }

    public Double getValorHoraCoordenacao() {
        return valorHoraCoordenacao;
    }

    @Override
    public Double getValorBonus() {
        return qtdHoraCoordenacao * valorHoraCoordenacao * 4.5 * 0.2;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "Quantidade Hora Coordenacao: " + qtdHoraCoordenacao +
                ", Valor Hora Coordenacao: " + valorHoraCoordenacao +
                ", Bônus total=" + getValorBonus() +
                "} " + super.toString();
    }
}
