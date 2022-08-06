package br.com.bandtec.projetodtos.requisicao;

// esta classe é um DTO usado para enviar uma requisição (Request) de Fruta
public class FrutaNovosUnidadePrecoRequest {

    private String novaUnidade;
    private Double novoPreco;

    public void setNovaUnidade(String novaUnidade) {
        this.novaUnidade = novaUnidade;
    }

    public void setNovoPreco(Double novoPreco) {
        this.novoPreco = novoPreco;
    }

    public String getNovaUnidade() {
        return novaUnidade;
    }

    public Double getNovoPreco() {
        return novoPreco;
    }
}
