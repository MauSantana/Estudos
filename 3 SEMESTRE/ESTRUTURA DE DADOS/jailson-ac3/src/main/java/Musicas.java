public class Musicas {
    private Integer id;
    private String nome;
    private Double nota;
    private String genero;
    private Integer qtdTocada;
    private Integer qtdVendidaParaArtista;
    private Integer qtdPlataformas;

    public Musicas(Integer id, String nome, Double nota, String genero, Integer qtdTocada, Integer qtdVendidaParaArtista, Integer qtdPlataformas) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.genero = genero;
        this.qtdTocada = qtdTocada;
        this.qtdVendidaParaArtista = qtdVendidaParaArtista;
        this.qtdPlataformas = qtdPlataformas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getQtdTocada() {
        return qtdTocada;
    }

    public void setQtdTocada(Integer qtdTocada) {
        this.qtdTocada = qtdTocada;
    }

    public Integer getQtdVendidaParaArtista() {
        return qtdVendidaParaArtista;
    }

    public void setQtdVendidaParaArtista(Integer qtdVendidaParaArtista) {
        this.qtdVendidaParaArtista = qtdVendidaParaArtista;
    }

    public Integer getQtdPlataformas() {
        return qtdPlataformas;
    }

    public void setQtdPlataformas(Integer qtdPlataformas) {
        this.qtdPlataformas = qtdPlataformas;
    }

    @Override
    public String toString() {
        return "Musicas{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", genero='" + genero + '\'' +
                ", qtdTocada=" + qtdTocada +
                ", qtdVendidaParaArtista=" + qtdVendidaParaArtista +
                ", qtdPlataformas=" + qtdPlataformas +
                '}';
    }
}
