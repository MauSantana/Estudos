
package br.com.bandtec.projeto.vendas;

public class VendedorComissao {
    
    private Integer codigo;
    private String nome;
    private Double vendas;
    private Double taxa;

    public VendedorComissao(Integer codigo, String nome, Double vendas, Double taxa) {
        this.codigo = 0;
        this.nome = nome;
        this.vendas = 0.0;
        this.taxa = 0.0;
    }
    
    public Double calcularSalario() {
        return (this.taxa * this.vendas) / 100;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getVendas() {
        return vendas;
    }

    public void setVendas(Double vendas) {
        this.vendas = vendas;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    @Override
    public String toString() {
        return "VendedorComissao{" + "codigo=" + codigo + ", nome=" + nome + ", vendas=" + vendas + ", taxa=" + taxa + '}';
    }

    
    
}
