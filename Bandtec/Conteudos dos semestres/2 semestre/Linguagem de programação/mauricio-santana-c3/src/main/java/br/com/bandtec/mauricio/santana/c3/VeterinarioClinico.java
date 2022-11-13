
package br.com.bandtec.mauricio.santana.c3;


public class VeterinarioClinico {
    
    private Integer codigo;
    private String nome;
    private Integer qtdConsulta;
    private Double valorConsulta;

    public VeterinarioClinico(Integer codigo, String nome, Integer qtdConsulta, Double valorConsulta) {
        this.codigo = codigo;
        this.nome = nome;
        this.qtdConsulta = qtdConsulta;
        this.valorConsulta = valorConsulta;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQtdConsulta() {
        return qtdConsulta;
    }


    public Double getValorConsulta() {
        return valorConsulta;
    }
    
    public Double calcularSalario(){
        return (this.qtdConsulta) * (this.valorConsulta);
    }
    
    @Override
    public String toString() {
        return "\nVeterinário Clinico:"
                + "\nCódigo: " + codigo
                + "\nNome: " + nome
                + "\nConsultas: " + qtdConsulta
                + "\nValor: " + valorConsulta
                + "\nSalário: " + calcularSalario();
    }
    
}
