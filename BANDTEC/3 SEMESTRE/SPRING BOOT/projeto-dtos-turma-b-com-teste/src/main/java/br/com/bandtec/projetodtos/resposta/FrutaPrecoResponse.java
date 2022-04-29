package br.com.bandtec.projetodtos.resposta;

// esta classe é um DTO usado para expor uma resposta (Response) de Fruta
public class FrutaPrecoResponse {

    private Integer id;
    private String nome;
    private Double valorTotalEstoque;

    public FrutaPrecoResponse(Integer id,
                              String nome,
                              Integer quantidadeEstoque,
                              Double precoUnitario) {
        if (quantidadeEstoque < 0 || precoUnitario < 0.0) {
            throw new IllegalArgumentException(
                    "Quantidade e preço deve ser >= 0"
            );
        }
        this.id = id;
        this.nome = nome;
        this.valorTotalEstoque = quantidadeEstoque * precoUnitario;
    }

    public Double getValorTotalEstoque() {
        return valorTotalEstoque;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
