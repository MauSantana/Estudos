/* Classe Engenheiro - herdeira de Funcionario */

public class Engenheiro extends Funcionario {

    // Atributo
    private Double salario;

    // Construtor
    public Engenheiro(String cpf, String nome, Double salario) {
        super(cpf, nome);
        this.salario = salario;
    }


    // Métodos

    // Implementação do método abstrato calcSalario()
    // Para gerar a estrutura do método, utilizo Alt+Insert e seleciono Implement method
    // Depois troco o return null para que o método retorne o que eu quero
    public Double calcSalario() {
        return salario;
    }

    // Método toString() - sobrescreve o método toString() herdado de Funcionario
    @Override
    public String toString() {
        return "Engenheiro{" +
                "salario=" + salario +
                "} " + super.toString();
    }
}
