/* Classe abstrata Funcionario
   Servirá de base para a criação das classes concretas Engenheiro, Vendedor e Horista
 */
public abstract class Funcionario {

    // Atributos
    // Atributos comuns a todos os funcionários
    // Poderia ter mais atributos além desses (aqui é só um exemplo)
    private String cpf;
    private String nome;

    // Construtor
    public Funcionario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Métodos

    // Método abstrato calcSalario()
    // Obriga que as classes concretas herdeiras desta classe implementem este método
    public abstract Double calcSalario();

    // Método toString() - Sobrescreve o método toString() herdado da classe Object
    @Override
    public String toString() {
        return "Funcionario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
