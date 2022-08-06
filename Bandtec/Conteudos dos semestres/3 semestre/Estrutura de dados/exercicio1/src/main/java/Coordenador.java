public class Coordenador implements Funcionario{

    private String nome;
    private Integer qtdHoraCoordenador;
    private Double valorHoraCoordenador;

    public Coordenador(String nome, Integer qtdHoraCoordenador, Double valorHoraCoordenador) {
        this.nome = nome;
        this.qtdHoraCoordenador = qtdHoraCoordenador;
        this.valorHoraCoordenador = valorHoraCoordenador;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQtdHoraCoordenador() {
        return qtdHoraCoordenador;
    }

    public Double getValorHoraCoordenador() {
        return valorHoraCoordenador;
    }

    @Override
    public Double getValorBonus() {
        return qtdHoraCoordenador * valorHoraCoordenador * 4.5 * 0.2;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "nome: " + nome + '\'' +
                ", Quantidade Hora Coordenador: " + qtdHoraCoordenador +
                ", Valor Hora Coordenador: " + valorHoraCoordenador +
                ", valor Total: " + getValorBonus() +
                '}';
    }
}
