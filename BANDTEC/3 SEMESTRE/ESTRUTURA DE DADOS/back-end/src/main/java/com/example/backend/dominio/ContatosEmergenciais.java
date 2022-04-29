package com.example.backend.dominio;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "contatosemergenciais")
public class ContatosEmergenciais {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contato_emergencial_id")
    private Integer contatoEmergencialID;

    @Column(name = "nome")
    private String nome;

    @Column(name = "datadenascimento")
    private LocalDate dataDeNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "celular")
    private String celular;

    @Column(name = "telefone")
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "numero_do_cadastro_vitima", referencedColumnName = "numero_do_cadastro")
    private Vitima vitima;


    //cosntrutores

    public ContatosEmergenciais() {
    }


    //metodos


    public Integer getContatoEmergencialID() {
        return contatoEmergencialID;
    }

    public void setContatoEmergencialID(Integer contatoEmergencialID) {
        this.contatoEmergencialID = contatoEmergencialID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
