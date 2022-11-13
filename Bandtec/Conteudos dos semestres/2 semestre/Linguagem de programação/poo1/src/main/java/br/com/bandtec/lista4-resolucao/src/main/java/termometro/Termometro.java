package termometro;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class Termometro {

    private Double temperaturaAtual;
    private Double temperaturaMinima;
    private Double temperaturaMaxima;

    public Termometro(Double temperaturaMinima, Double temperaturaMaxima) {
        this.temperaturaAtual = 0.0;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public void aumentarTemperatura(Double temperatura) {
        if ((this.temperaturaAtual + temperatura) > temperaturaMaxima) {
            this.temperaturaAtual = this.temperaturaMaxima;
        } else {
            this.temperaturaAtual += temperatura;
        }
    }

    public void diminuirTemperatura(Double temperatura) {
        if ((this.temperaturaAtual - temperatura) < temperaturaMinima) {
            this.temperaturaAtual = this.temperaturaMinima;
        } else {
            this.temperaturaAtual -= temperatura;
        }
    }

    public void exibeFahreinheit() {
        System.out.println(String.format("Fahreinheit: F%.1f",
                ((this.temperaturaAtual * 1.800) + 32.0)));
    }

    @Override
    public String toString() {
        return String.format("\nTermometro\nAtual: %.1f\nMinima: %.1f\nMaxima: %.1f\n",
                this.temperaturaAtual, this.temperaturaMinima, this.temperaturaMaxima);
    }
}
