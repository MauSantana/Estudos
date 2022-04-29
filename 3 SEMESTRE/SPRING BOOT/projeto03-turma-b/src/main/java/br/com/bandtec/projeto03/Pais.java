package br.com.bandtec.projeto03;

public class Pais {
    private String nome;
    private Integer ouros;
    private Integer pratas;
    private Integer bronzes;

    public Pais(String nome, Integer ouros, Integer pratas, Integer bronzes) {
        this.nome = nome;
        this.ouros = ouros;
        this.pratas = pratas;
        this.bronzes = bronzes;
    }

    public String getNome() {
        return nome;
    }

    public Integer getOuros() {
        return ouros;
    }

    public Integer getPratas() {
        return pratas;
    }


/*
Campo ou atributo ou propriedade:
    calculado ou virtual
*/
    public Integer getTotalMedalhas() {
        return ouros + pratas + bronzes;
    }
}
