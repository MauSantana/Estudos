package br.com.bandtec.mauricio.santana.c2;

public class Aluno {

    private Integer ra;
    private String nome;
    private Boolean ativo;
    private Boolean inadimplente;
    private Double media;

    public Aluno(Integer ra, String nome, Boolean ativo,
            Boolean inadimplente) {
        this.ra = ra;
        this.nome = nome;
        this.ativo = true;
        this.inadimplente = false;
        this.media = 0.0;
    }

    public Integer getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Boolean getInadimplente() {
        return inadimplente;
    }

    public Double getMedia() {
        return media;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setInadimplente(Boolean inadimplente) {
        this.inadimplente = inadimplente;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public void calcularMedia(Double nota1, Double nota2) {
        this.media = (nota1 * 0.4) + (nota2 * 0.6);

    }

    @Override
    public String toString() {
        return String.format("ALUNO: \nRA: %d\nNome: %s\nAtivo: %s\n"
                + "Inadimplente: %s\nMedia: %.2f\n"
                + "-----------\n"
                + "O Aluno %s foi ?", this.ra, this.nome, this.ativo,
                this.inadimplente, this.media, this.nome);
    }

}
