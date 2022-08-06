import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    private List<Funcionario> funcionarios;

    public ControleBonus() {
        funcionarios = new ArrayList<Funcionario>();
    }

    public void registrarBeneficiado(Funcionario f){
        funcionarios.add(f);
    }

    public void exibirBeneficiado(){
            System.out.println("\n Funcionários benefíciados");
            for (Funcionario f : funcionarios)
                System.out.println(f);

        }

    public Double calcularTotal(){
        Double total = 0.0;
        for (Funcionario f : funcionarios){
            total += f.getValorBonus();
        }
        return total;
    }

    @Override
    public String toString() {
        return "ControleBonus: {" +
                "Funcionários: " + funcionarios +
                "Calcular Total: = " + calcularTotal() +
                '}';
    }
}
