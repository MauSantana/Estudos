public abstract class Funcionario {

    private String nome;
    private Integer qtdHoraAula;
    private Double valorHoraAula;

    public Funcionario(String nome, Integer qtdHoraAula, Double valorHoraAula) {
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


    public abstract Double getValorBonus();


    @Override
    public String toString() {
        return "Funcionario{" +
                "Nome: " + nome + '\'' +
                ", Quantidade Hora Aula: " + qtdHoraAula +
                ", Valor Hora Aula: " + valorHoraAula +
                '}';
    }
}
