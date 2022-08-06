package professor;

/**
 *
 * @author diego <diego.lima@bandtec.com.br>
 */
public class Professor {

    protected Integer codigo;
    protected String nome;
    protected Integer horas;
    protected Double valorHora;

    public Professor(Integer codigo, String nome, Integer horas, Double valorHora) {
        this.codigo = codigo;
        this.nome = nome;
        this.horas = horas;
        this.valorHora = valorHora;
    }
    
    public Double calcularSalario(){
        return (this.valorHora * this.horas) * 4.5;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getHoras() {
        return horas;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return "\nProfessor: " 
                + "codigo: " + codigo 
                + "\nnome:" + nome 
                + "\nhoras:" + horas 
                + "\nvalorHora:" + valorHora;
    }
}
