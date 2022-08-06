/* Classe Produto - classe abstrata, implementa a interface Tributavel
   As classes herdeiras de Produto, que forem concretas, serão obrigadas
   a implementarem os métodos que estão na interface Tributavel
 */
public abstract class Produto implements Tributavel {

    // Atributos
    private Integer codigo;
    private String descricao;
    private Double preco;

    // Construtor
    public Produto(Integer codigo, String descricao, Double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }



    // Métodos

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

    // getter do preco

    public Double getPreco() {
        return preco;
    }
}
