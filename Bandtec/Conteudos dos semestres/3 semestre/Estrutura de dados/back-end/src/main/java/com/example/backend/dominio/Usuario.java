package com.example.backend.dominio;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Usuario {

    //Atributos
    private String nome;
    private String cpf;
    private String rg;
    private String username;
    private String senha;
    private LocalDate datadenascimento;
    private String email;

    // construtores

    public Usuario(String nome, String cpf, String rg, String userName, String senha, LocalDate dataDeNascimento, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.username = userName;
        this.senha = senha;
        this.datadenascimento = dataDeNascimento;
        this.email = email;
    }

    public Usuario() {

    }


    //metodos


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataDeNascimento() {
        return datadenascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.datadenascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
