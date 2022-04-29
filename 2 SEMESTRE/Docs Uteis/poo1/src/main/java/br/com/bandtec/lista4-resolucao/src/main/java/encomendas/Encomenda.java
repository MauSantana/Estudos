package encomendas;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class Encomenda {

    Double altura = 0.0;
    Double largura = 0.0;
    String enderecoRemetente = "";
    String enderecoDestinatario = "";
    Double distancia = 0.0;
    Double valorEncomenda = 0.0;

    void emitirEtiqueta() {
        System.out.println("****** ETIQUETA PARA ENVIO ******");
        System.out.println(String.format("Endereço do remetente: %s",
                enderecoRemetente));
        System.out.println(String.format("Endereço do Destinatário: %s",
                enderecoDestinatario));
        System.out.println(String.format("Altura do pacote: %.2f cm", altura));
        System.out.println(String.format("Largura do pacote: %.2f cm", largura));
        System.out.println(String.format("-".repeat(32)));
        System.out.println(String.format("Valor da encomenda: R$%.2f", valorEncomenda));
        System.out.println(String.format("Valor do frete: R$%.2f", calcularFrete()));
        System.out.println(String.format("-".repeat(32)));
        System.out.println(String.format("Valor total: R$%.2f",
                (valorEncomenda + calcularFrete())));
    }

    Double calcularFrete() {
        return calcularPrecoDistancia() + calcularPrecoDimensoes();
    }

    Double calcularPrecoDimensoes() {

        //preço mínimo
        Double taxa = 0.01;

        if (this.altura > 15 && this.largura > 50) {
            taxa = 0.05;
        } else if (this.altura > 7 && this.largura > 16) {
            taxa = 0.03;
        }

        return valorEncomenda + (valorEncomenda * taxa);
    }

    Double calcularPrecoDistancia() {

        //preço mínimo
        Double valor = 3.0;

        if (this.distancia > 200) {
            valor = 7.0;
        } else if (this.distancia > 50) {
            valor = 5.0;
        }

        return valor;
    }
}
