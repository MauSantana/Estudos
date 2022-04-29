package br.com.bandtec.projetodtos.resposta;

import br.com.bandtec.projetodtos.dominio.Fruta;

// esta classe é um DTO usado para expor uma resposta (Response) de Fruta
public class FrutaSimplesResponse {

    private Integer id;
    private String nome;

    public FrutaSimplesResponse(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public FrutaSimplesResponse(Fruta fruta) {
        this.id = fruta.getId();
        this.nome = fruta.getNome();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
