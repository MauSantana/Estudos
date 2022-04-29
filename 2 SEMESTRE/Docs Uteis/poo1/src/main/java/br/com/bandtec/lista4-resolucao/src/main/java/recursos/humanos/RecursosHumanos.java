package recursos.humanos;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class RecursosHumanos {

    private Integer salariosReajustados;
    private Integer qtdColaboradoresPromovidos;

    public RecursosHumanos() {
        this.salariosReajustados = 0;
        this.qtdColaboradoresPromovidos = 0;
    }

    public void reajustarSalario(Colaborador colaborador, Double reajuste) {
        Double quantiaASerReajustada = colaborador.getSalario() * (reajuste / 100);
        colaborador.setSalario(colaborador.getSalario() + quantiaASerReajustada);
        salariosReajustados++;
    }

    public void promoverColaborador(
            Colaborador colaborador, String novoCargo, Double novoSalario) {
        if (novoSalario > colaborador.getSalario()) {
            colaborador.setCargo(novoCargo);
            colaborador.setSalario(novoSalario);
            qtdColaboradoresPromovidos++;
        } else {
            System.out.println("Não foi possível realizar operação.");
        }
    }

    @Override
    public String toString() {
        return String.format("\tRH\nSalarios reajustados: %d\nColaboradores promovidos: %d",
                this.salariosReajustados, this.qtdColaboradoresPromovidos);
    }
}
