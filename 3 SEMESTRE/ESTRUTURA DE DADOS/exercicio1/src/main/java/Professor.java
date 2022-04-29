public class Professor implements Funcionario{

    private String nome;
    private Integer qtdHoraAula;
    private Double valorHoraAula;

    public Professor(String nome, Integer qtdHoraAula, Double valorHoraAula) {
        this.nome = nome;
        this.qtdHoraAula = qtdHoraAula;
        this.valorHoraAula = valorHoraAula;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQtdHoraAula() {
        return qtdHoraAula;
    }

    public Double getValorHoraAula() {
        return valorHoraAula;
    }

    @Override
    public Double getValorBonus() {
        return qtdHoraAula * valorHoraAula * 4.5 * 0.15;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "Nome: " + nome + '\'' +
                ", Quantidade Hora Aula: " + qtdHoraAula +
                ", Valor Hora Aula: " + valorHoraAula +
                ", Valor Total: " + getValorBonus() +
                '}';
    }
}
