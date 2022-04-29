package termometro;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class TesteTermometro {

    public static void main(String[] args) {

        Termometro termometro = new Termometro(-17.0, 40.0);

        termometro.aumentarTemperatura(25.0);
        termometro.aumentarTemperatura(25.0);

        System.out.println(termometro);
        termometro.exibeFahreinheit();

        termometro.diminuirTemperatura(30.0);
        termometro.diminuirTemperatura(10.0);
        
        System.out.println(termometro);
        termometro.exibeFahreinheit();
    }
}
