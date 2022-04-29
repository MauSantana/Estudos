public class Professor extends Funcionario{

    public Professor(String nome, Integer qtdHoraAula, Double valorHoraAula) {
        super(nome, qtdHoraAula, valorHoraAula);
    }

    @Override
    public Double getValorBonus() {
        return getQtdHoraAula() * getValorHoraAula();
    }

    @Override
    public String toString() {
        return "Professor{} " + super.toString();
    }

}
