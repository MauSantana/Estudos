public class Livro {
    private String nome;
    private String autor;
    private String tema;
    private Double copiasVendidas;

    public Livro(String nome, String autor, String tema, Double copiasVendidas) {
        this.nome = nome;
        this.autor = autor;
        this.tema = tema;
        this.copiasVendidas = copiasVendidas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                ", tema='" + tema + '\'' +
                ", copiasVendidas=" + copiasVendidas +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Double getCopiasVendidas() {
        return copiasVendidas;
    }

    public void setCopiasVendidas(Double copiasVendidas) {
        this.copiasVendidas = copiasVendidas;
    }
}
