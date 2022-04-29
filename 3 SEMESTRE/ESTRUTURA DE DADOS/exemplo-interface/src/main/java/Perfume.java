public class Perfume extends Produto {

    // Atributo
    private String fragrancia;

    // Construtor
    public Perfume(Integer codigo, String descricao, Double preco, String fragrancia) {
        super(codigo, descricao, preco);
        this.fragrancia = fragrancia;
    }

    // Métodos

    public Double getValorTributo() {
        return getPreco() * 0.27;
    }

    @Override
    public String toString() {
        return "Perfume{" +
                "fragrancia='" + fragrancia + '\'' +
                ", tributo=" + getValorTributo() +
                "} " + super.toString();
    }
}
