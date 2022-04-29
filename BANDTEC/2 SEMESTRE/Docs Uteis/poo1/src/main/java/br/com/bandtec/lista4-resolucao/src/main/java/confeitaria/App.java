package confeitaria;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class App {

    public static void main(String[] args) {

        Bolo bolo1 = new Bolo();
        Bolo bolo2 = new Bolo();
        Bolo bolo3 = new Bolo();

        bolo1.sabor = "Red velvet (Bolo gourmet)";
        bolo2.sabor = "Brigadeirão (Escolha da galera)";
        bolo3.sabor = "Fubá Maroto (Clássico)";

        bolo1.valor = 20.0;
        bolo2.valor = 12.0;
        bolo3.valor = 8.0;

        bolo1.comprarBolo(50);
        bolo1.comprarBolo(20);
        bolo1.comprarBolo(100);
        bolo1.exibirRelatorio();

        bolo2.comprarBolo(8);
        bolo2.comprarBolo(2);
        bolo2.exibirRelatorio();

        bolo3.comprarBolo(1);
        bolo3.exibirRelatorio();
    }
}
