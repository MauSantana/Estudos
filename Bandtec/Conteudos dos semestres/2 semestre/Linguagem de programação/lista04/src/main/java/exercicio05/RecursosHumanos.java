
package exercicio05;


public class RecursosHumanos {
    private Integer totalPromovidos;
    private Integer totalReajustes;

    public RecursosHumanos() {
        this.totalPromovidos = 0;
        this.totalReajustes = 0;
    }
    
    
    
    public void reajustarSalario(Colaborador colab, Double valorReajuste){
        Double salarioAtual = colab.getSalario();
        Double valorASeReajustado = salarioAtual * (valorReajuste / 100);
        colab.setSalario(salarioAtual + valorASeReajustado);
        totalReajustes ++;
    }
    
    public void promoverColaborador(Colaborador colab, String novoCargo, 
            Double novoSalario){
        if (colab.getSalario() < novoSalario) {
            colab.setSalario(novoSalario);
            colab.setCargo(novoCargo);
            totalPromovidos ++;
        }else {
            System.out.println("Para promover, ofereça um salario maior que o atual");
        }
    }

    @Override
    public String toString() {
        return String.format("Total promovidos: %d\nTotal Reajustados: %d",
                this.totalPromovidos, this.totalReajustes);
    }

    
    
}
