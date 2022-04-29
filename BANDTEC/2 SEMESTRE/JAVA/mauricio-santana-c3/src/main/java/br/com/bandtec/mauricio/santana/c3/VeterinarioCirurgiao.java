
package br.com.bandtec.mauricio.santana.c3;

public class VeterinarioCirurgiao extends VeterinarioClinico{
    
    private Integer qtdCirurgia;
    private Double valorCirurga;
    
    public VeterinarioCirurgiao(Integer codigo, String nome, Integer qtdCirurgia, Double valorCirurga, Integer qtdConsulta, Double valorConsulta) {
        super(codigo, nome, qtdConsulta, valorConsulta);
        this.qtdCirurgia = qtdCirurgia;
        this.valorCirurga = valorCirurga;
    }

    public Integer getQtdCirurgia() {
        return qtdCirurgia;
    }

    public Double getValorCirurga() {
        return valorCirurga;
    }
    
    @Override
    public Double calcularSalario() {
        return (this.qtdCirurgia) * (this.valorCirurga);
    }
    
     @Override
    public String toString() {
        return "\nVeterinário Cirurgião:" +
                "\nCódigo: "+super.getCodigo() +
                "\nNome: "+super.getNome()+
                "\nConsultas: " + qtdCirurgia
                + "\nValor: " + valorCirurga
                + "\nSalário: " + calcularSalario();
    }
}
