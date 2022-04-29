package confeitaria;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class Bolo {

    String sabor;
    Double valor;
    Integer qtdVendida = 0;
    String fraseVenda = "Venda realizada, %d bolos de %s";

    void comprarBolo(Integer quantidade) {
        if ((quantidade + qtdVendida) <= 100) {
            this.qtdVendida += quantidade;
            System.out.println(String.format(fraseVenda, quantidade, this.sabor));
        } else {
            System.out.println("Seu pedido ultrapassou nosso limite diário para esse bolo");
        }
    }

    void exibirRelatorio() {
        System.out.println(String.format("\nO bolo sabor %s, foi comprado %d vezes hoje, totalizando R$%.2f\n",
                this.sabor, this.qtdVendida, (this.valor * this.qtdVendida)));
    }
}
