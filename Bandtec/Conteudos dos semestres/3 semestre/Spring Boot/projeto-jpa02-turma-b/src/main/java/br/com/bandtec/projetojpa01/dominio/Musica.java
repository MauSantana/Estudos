package br.com.bandtec.projetojpa01.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/*
Esta anotação indica que a classe será uma Entidade
Ou seja, ela vai mapear, espelhar, uma tabela do banco de dados
 */
@Entity
public class Musica {

    @Id // indica que o atributo será a chave primária (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que o valor do campo será autoincremento
    private Integer id;

    private String nome;
    private LocalDate lancamento;
    private Integer copiasVendidas;

    private String letra;

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
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

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public Integer getCopiasVendidas() {
        return copiasVendidas;
    }

    public void setCopiasVendidas(Integer copiasVendidas) {
        this.copiasVendidas = copiasVendidas;
    }
}
