package br.com.bandtec.exercicios.semelhantes.transportadora;

public class Transportadora {

    private String nome;
    private Integer envios;
    private Double faturamentoDiario;

    public Transportadora(String nome) {
        this.nome = nome;
        this.envios = 0;
        this.faturamentoDiario = 0.0;
    }

    public void emitirEtiqueta(Encomenda encomenda) {

        StringBuilder str = new StringBuilder();

        str.append("-".repeat(32));
        str.append("\n** ETIQUETA PARA ENVIO **");
        str.append("\n %s \n");
        str.append("-".repeat(32));
        str.append("\n-> Valor do frete: R$%.2f\n");
        str.append("-".repeat(32));
        str.append("\n-> Valor total: R$%.2f\n");
        str.append("-".repeat(32));

        Double valorFrete = calcularFrete(encomenda);

        System.out.println(
                String.format(
                        str.toString(),
                        encomenda.toString(),
                        valorFrete,
                        (valorFrete + encomenda.getValorEncomenda())
                )
        );
    }

    public Double calcularFrete(Encomenda e) {
        return calcularPrecoDistancia(e) + calcularPrecoDimensoes(e);
    }

    private Double calcularPrecoDimensoes(Encomenda e) {

        //preço mínimo
        Double taxa = 0.01;

        if (e.getAltura() > 15 && e.getLargura() > 50) {
            taxa = 0.05;
        } else if (e.getAltura() > 7 && e.getLargura() > 16) {
            taxa = 0.03;
        }

        return e.getValorEncomenda() + (e.getValorEncomenda() * taxa);
    }

    private Double calcularPrecoDistancia(Encomenda e) {

        //preço mínimo
        Double valor = 3.0;

        if (e.getDistancia() > 200) {
            valor = 7.0;
        } else if (e.getDistancia() > 50) {
            valor = 5.0;
        }

        return valor;
    }

    public void enviar(Encomenda encomenda) {

        if (encomenda.isEnviado()) {
            System.out.println("Desculpe essa encomenda já foi enviada.");
        } else {
            encomenda.setEnviado(true);
            this.envios++;
            this.faturamentoDiario += this.calcularFrete(encomenda);
            this.emitirEtiqueta(encomenda);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("\n---TRANSPORTADORA %s---\n");
        str.append("  envios realizados: %d\n");
        str.append("  faturamento diário: R$%.2f\n");

        return String.format(str.toString(),
                this.nome, this.envios, this.faturamentoDiario);
    }
}
