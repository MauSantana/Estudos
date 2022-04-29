public class Produto {
    private Integer codProduto;
    private String nome;
    private Double preco;
    private String avaliacao;
    private Integer quantidadeVendida;

    public Produto(Integer codProduto,
                   String nome,
                   Double preco,
                   String avaliacao,
                   Integer quantidadeVendida) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.quantidadeVendida = 0;
    }


    public void comprar(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public Double calcularFaturamento() {
        return quantidadeVendida * preco;
    }


    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }


    @Override
    public String toString() {
        return String.format("%06d  %-14s  %7.2f  %7s %14.3f", codProduto,nome,preco,avaliacao,calcularFaturamento());
    }
}
