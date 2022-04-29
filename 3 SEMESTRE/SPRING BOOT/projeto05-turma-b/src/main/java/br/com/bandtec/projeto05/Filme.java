package br.com.bandtec.projeto05;

public class Filme {

    private Integer id;
    private String nome;

    public Filme(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
