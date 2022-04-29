package empregado;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class Empregado {

    private String nome;
    private String cargo;
    private Double salario;

    public Empregado(String nome, String cargo, Double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void reajustarSalario(Double porcentagem) {
        this.salario += this.salario * (porcentagem / 100);
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public Double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nCargo:%s\nSalario: R$%.2f",
                this.nome, this.cargo, this.salario);
    }
}
